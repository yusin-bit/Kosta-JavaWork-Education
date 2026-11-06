import { useEffect, useState } from 'react'
import { api, requestOptions, uploadImage } from '../../api'
import { compressImage } from '../../imageUtils'
import ItemPhoto from '../ItemPhoto'
import FormModal from '../modals/FormModal'
import useTableLabels from '../../useTableLabels'

// short: 휴대폰 하단 메뉴에 표시하는 짧은 이름
const tabs = [
  { key: 'summary', icon: '⌂', title: '전체 현황', sub: '현황·통계', short: '현황' },
  { key: 'users', icon: '◎', title: '회원 관리', sub: '정지·탈퇴·삭제', short: '회원' },
  { key: 'items', icon: '▣', title: '물품 관리', sub: '수정·삭제·복구', short: '물품' },
  { key: 'categories', icon: '☰', title: '카테고리 관리', sub: '분류 추가·삭제', short: '분류' },
  { key: 'posts', icon: '▦', title: '게시글 관리', sub: '수정·삭제', short: '게시글' },
  { key: 'rentals', icon: '↺', title: '대여 관리', sub: '거절·강제 처리', short: '대여' },
  { key: 'notices', icon: '✉', title: '공지사항', sub: '등록·게시', short: '공지' },
  { key: 'admins', icon: '♛', title: '관리자 계정', sub: '추가·비밀번호', short: '관리자' },
  { key: 'logs', icon: '☷', title: '활동 기록', sub: '관리자 작업 내역', short: '기록' },
]

const rentalStatusFilters = [
  { key: 'all', label: '전체', codes: null },
  { key: 'requested', label: '승인 대기', codes: [100] },
  { key: 'progress', label: '진행 중', codes: [101, 110, 200, 201, 210] },
  { key: 'done', label: '완료', codes: [211] },
  { key: 'rejected', label: '거절·취소', codes: [102] },
]

const shortDate = value => (value ? value.slice(0, 16) : '-')
const toInputDate = value => (value ? value.replace(' ', 'T').slice(0, 16) : '')

// 관리자 화면: 회원 화면(AppView)과 같은 사이드바·표 스타일을 쓴다
export default function AdminView({ admin, onLogout, toast }) {
  const [tab, setTab] = useState('summary')
  const [summary, setSummary] = useState(null)
  const [stats, setStats] = useState(null)
  const [users, setUsers] = useState([])
  const [posts, setPosts] = useState([])
  const [rentals, setRentals] = useState([])
  const [items, setItems] = useState([])
  const [categories, setCategories] = useState([])
  const [notices, setNotices] = useState([])
  const [admins, setAdmins] = useState({ me: '', admins: [] })
  const [logs, setLogs] = useState([])
  const [query, setQuery] = useState('')
  const [rentalFilter, setRentalFilter] = useState('all')
  const [newBigName, setNewBigName] = useState('')
  const [newSmall, setNewSmall] = useState({ bigCode: '', name: '' })
  // 범용 입력 모달: { title, fields, submitLabel, path, extra, reload }
  const [form, setForm] = useState(null)
  useTableLabels()

  const load = async name => {
    try {
      if (name === 'summary') {
        setSummary((await api('/api/admin/summary')).summary)
        setStats(await api('/api/admin/stats'))
      }
      if (name === 'users') setUsers((await api('/api/admin/users')).users)
      if (name === 'posts') setPosts((await api('/api/admin/posts')).posts)
      if (name === 'rentals') setRentals((await api('/api/admin/rentals')).rentals)
      if (name === 'items') {
        setItems((await api('/api/admin/items')).items)
        setCategories((await api('/api/admin/categories')).categories)
      }
      if (name === 'categories') setCategories((await api('/api/admin/categories')).categories)
      if (name === 'notices') setNotices((await api('/api/admin/notices')).notices)
      if (name === 'admins') setAdmins(await api('/api/admin/admins'))
      if (name === 'logs') setLogs((await api('/api/admin/logs')).logs)
    } catch (error) {
      toast(error.message)
    }
  }

  useEffect(() => {
    load(tab)
    setQuery('')
    // 휴대폰에서는 하단 메뉴가 가로로 스크롤되므로 선택한 메뉴가 보이게 맞춘다
    document.querySelector('#adminView .nav-item.active')?.scrollIntoView({ inline: 'nearest', block: 'nearest' })
  }, [tab])

  // 확인 → 관리자 작업 실행 → 목록 다시 불러오기
  const runAction = async (question, path, body, reload) => {
    if (question && !confirm(question)) return false
    try {
      toast((await api(path, requestOptions(body))).message)
      await load(reload)
      return true
    } catch (error) {
      toast(error.message)
      return false
    }
  }

  // 관리자 사진 등록/변경: 고른 사진을 줄여서 바로 올린다 (부적절한 사진 교체용)
  const adminPhoto = async (item, e) => {
    const file = e.target.files?.[0]
    e.target.value = ''
    if (!file) return
    try {
      const blob = await compressImage(file)
      toast((await uploadImage(`/api/admin/items/image?itemNum=${item.itemNum}`, blob)).message)
      await load('items')
    } catch (error) {
      toast(error.message)
    }
  }

  const openForm = config => setForm(config)
  const submitForm = async values => {
    if (await runAction(null, form.path, { ...form.extra, ...values }, form.reload ?? tab)) setForm(null)
  }

  // 카테고리 행(대분류×소분류)을 대분류별로 묶는다
  const categoryGroups = categories.reduce((groups, row) => {
    let group = groups.find(g => g.bigCode === row.bigCode)
    if (!group) groups.push(group = { bigCode: row.bigCode, bigName: row.bigName, smalls: [] })
    if (row.smallCode) group.smalls.push(row)
    return groups
  }, [])
  const smallCategoryOptions = categoryGroups.flatMap(g => g.smalls.map(s => ({ value: s.smallCode, label: `${g.bigName} · ${s.smallName}` })))

  const addBig = async e => {
    e.preventDefault()
    if (await runAction(null, '/api/admin/categories/big/create', { name: newBigName }, 'categories')) setNewBigName('')
  }

  const addSmall = async e => {
    e.preventDefault()
    if (await runAction(null, '/api/admin/categories/small/create', newSmall, 'categories')) setNewSmall(prev => ({ ...prev, name: '' }))
  }

  const resetPassword = user => openForm({
    title: `${user.id} 임시 비밀번호`, eyebrow: 'MEMBER', description: '회원의 기존 로그인은 모두 끊기고, 이 비밀번호로 다시 로그인해야 합니다.',
    fields: [{ name: 'newPassword', label: '임시 비밀번호 (4~20자)', type: 'password', maxLength: 20 }],
    submitLabel: '임시 비밀번호 설정', path: '/api/admin/users/reset-password', extra: { userId: user.id }, reload: 'users',
  })

  const suspendUser = user => openForm({
    title: `${user.id} 이용 정지`, eyebrow: 'MEMBER', description: '정지되면 즉시 로그아웃되고, 해제할 때까지 로그인할 수 없습니다. 사유는 회원에게 표시됩니다.',
    fields: [{ name: 'reason', label: '정지 사유 (100자 이내)', maxLength: 100, placeholder: '예: 반납 지연 반복' }],
    submitLabel: '이용 정지', path: '/api/admin/users/suspend', extra: { userId: user.id }, reload: 'users',
  })

  const editUser = user => openForm({
    title: `${user.id} 정보 수정`, eyebrow: 'MEMBER',
    fields: [
      { name: 'nickname', label: '닉네임', value: user.nickname, maxLength: 10 },
      { name: 'name', label: '이름', value: user.name, maxLength: 10 },
      { name: 'phone', label: '전화번호', type: 'tel', value: user.phone, maxLength: 13 },
    ],
    submitLabel: '수정 완료', path: '/api/admin/users/update', extra: { userId: user.id }, reload: 'users',
  })

  const withdrawUser = user => runAction(
    `${user.id} 회원을 탈퇴 처리할까요?\n\n`
    + '· 로그인할 수 없게 되고, 이름·닉네임·전화번호가 가려집니다.\n'
    + '· 지난 대여 기록은 남습니다. (상대방 내역에는 "탈퇴회원"으로 표시)\n'
    + '· 승인 대기 중인 신청은 자동으로 거절되고, 물품은 대여 목록에서 빠집니다.\n'
    + '· 되돌릴 수 없습니다.',
    '/api/admin/users/withdraw', { userId: user.id }, 'users')

  const deleteUser = user => openForm({
    title: `${user.id} 완전 삭제`, eyebrow: 'DANGER',
    description: `회원과 함께 물품 ${user.itemCount}개, 대여 글 ${user.postCount}개, `
      + `대여 기록 최대 ${user.rentalCount + user.lentCount}건(빌린 기록 ${user.rentalCount} + 이 회원 물품을 남이 빌린 기록 ${user.lentCount})이 DB 에서 영구히 지워집니다. `
      + '다른 회원의 대여 내역에서도 사라지며 되돌릴 수 없습니다.'
      + (user.activeCount > 0 ? ` 진행 중인 대여 ${user.activeCount}건을 먼저 강제 완료/취소해야 합니다.` : ''),
    fields: [{ name: 'confirmId', label: `확인을 위해 회원 아이디(${user.id})를 입력하세요`, maxLength: 20, placeholder: user.id }],
    submitLabel: '완전 삭제', path: '/api/admin/users/delete', extra: { userId: user.id }, reload: 'users',
  })

  const editItem = item => openForm({
    title: `${item.itemNum}번 물품 수정`, eyebrow: 'ITEM',
    fields: [
      { name: 'itemName', label: '물품명', value: item.itemName, maxLength: 50 },
      { name: 'smallCategoryCode', label: '분류', type: 'select', value: item.smallCategoryCode, options: smallCategoryOptions },
    ],
    submitLabel: '수정 완료', path: '/api/admin/items/update', extra: { itemNum: item.itemNum }, reload: 'items',
  })

  const editPost = post => openForm({
    title: `${post.postNum}번 게시글 수정`, eyebrow: 'POST', description: '부적절한 문구를 정리할 때 사용합니다.',
    fields: [
      { name: 'title', label: '제목', value: post.title, maxLength: 50 },
      { name: 'content', label: '설명', type: 'textarea', value: post.content },
      { name: 'rentDate', label: '대여 시작', type: 'datetime-local', value: toInputDate(post.rentDate) },
      { name: 'returnDate', label: '반납', type: 'datetime-local', value: toInputDate(post.returnDate) },
      { name: 'addr', label: '거래 장소', value: post.addr, maxLength: 255 },
    ],
    submitLabel: '수정 완료', path: '/api/admin/posts/update', extra: { postNum: post.postNum }, reload: 'posts',
  })

  const noticeForm = notice => openForm({
    title: notice ? '공지 수정' : '새 공지', eyebrow: 'NOTICE', description: '게시 중인 공지는 모든 회원 화면 상단에 표시됩니다.',
    fields: [
      { name: 'title', label: '제목 (100자 이내)', value: notice?.title, maxLength: 100 },
      { name: 'content', label: '내용 (1000자 이내)', type: 'textarea', value: notice?.content, maxLength: 1000 },
    ],
    submitLabel: notice ? '수정 완료' : '공지 등록', path: notice ? '/api/admin/notices/update' : '/api/admin/notices/create',
    extra: notice ? { noticeNum: notice.noticeNum } : {}, reload: 'notices',
  })

  const addAdmin = () => openForm({
    title: '관리자 추가', eyebrow: 'ADMIN', description: '관리자 비밀번호는 영문과 숫자를 포함해 8자 이상이어야 합니다.',
    fields: [
      { name: 'id', label: '아이디 (영문·숫자·_ 4~20자)', maxLength: 20 },
      { name: 'name', label: '이름 (10자 이내)', maxLength: 10 },
      { name: 'password', label: '비밀번호', type: 'password', maxLength: 64 },
    ],
    submitLabel: '관리자 추가', path: '/api/admin/admins/create', reload: 'admins',
  })

  const changeMyPassword = () => openForm({
    title: '내 비밀번호 변경', eyebrow: 'ADMIN', description: '변경하면 다른 기기의 관리자 로그인은 끊깁니다.',
    fields: [
      { name: 'currentPassword', label: '현재 비밀번호', type: 'password', maxLength: 64 },
      { name: 'newPassword', label: '새 비밀번호 (영문+숫자 8자 이상)', type: 'password', maxLength: 64 },
    ],
    submitLabel: '비밀번호 변경', path: '/api/admin/password', reload: 'admins',
  })

  const q = query.trim().toLowerCase()
  const match = (...values) => !q || values.some(v => String(v ?? '').toLowerCase().includes(q))
  const current = tabs.find(t => t.key === tab)
  const inProgress = status => [101, 110, 200, 201, 210].includes(status)

  return (
    <section className="app-shell" id="adminView">
      <aside className="sidebar">
        <a className="brand" href="#">빌림<span>.</span></a>
        <nav className="main-nav" aria-label="관리자 메뉴">
          {tabs.map(t => (
            <button key={t.key} className={`nav-item${tab === t.key ? ' active' : ''}`} onClick={() => setTab(t.key)}>
              <span className="nav-icon">{t.icon}</span>
              <span><b>{t.title}</b><small>{t.sub}</small><i className="nav-short">{t.short}</i></span>
            </button>
          ))}
        </nav>
        <div className="sidebar-profile">
          <div className="avatar">관</div>
          <div><b>{admin.name}</b><small>{admin.id} · 관리자</small></div>
          <button aria-label="로그아웃" onClick={onLogout}>↪</button>
        </div>
      </aside>

      <main className="workspace">
        <header className="topbar">
          <div><p className="eyebrow">ADMIN CONSOLE</p><h2 id="adminPageTitle">{current.title}</h2></div>
          <div className="top-actions">
            <button className="btn outline" onClick={() => load(tab)}>새로고침</button>
            <button className="topbar-logout mobile-only" onClick={onLogout}>로그아웃</button>
          </div>
        </header>

        {tab === 'summary' && summary && (
          <section className="page active">
            <div className="summary-grid">
              <article className="summary-card"><span className="summary-icon blue">◎</span><div><small>회원</small><strong>{summary.users}</strong></div></article>
              <article className="summary-card"><span className="summary-icon amber">▦</span><div><small>물품</small><strong>{summary.items}</strong></div></article>
              <article className="summary-card"><span className="summary-icon green">✎</span><div><small>대여 글</small><strong>{summary.posts}</strong></div></article>
            </div>
            <div className="summary-grid">
              <article className="summary-card"><span className="summary-icon blue">↗</span><div><small>승인 대기</small><strong>{summary.requested}</strong></div></article>
              <article className="summary-card"><span className="summary-icon amber">◷</span><div><small>진행 중</small><strong>{summary.inProgress}</strong></div></article>
              <article className="summary-card"><span className="summary-icon green">✓</span><div><small>완료 / 거절</small><strong>{summary.completed} / {summary.rejected}</strong></div></article>
            </div>
            {stats && (
              <div className="stat-grid" id="adminStats">
                {[['인기 카테고리 (대여 신청 수)', stats.topCategories], ['대여 완료가 많은 회원', stats.topLenders], ['대여 신청이 많은 회원', stats.topBorrowers]].map(([label, rows]) => (
                  <article className="panel stat-panel" key={label}>
                    <h4>{label}</h4>
                    <ol>{rows.length ? rows.map(r => <li key={r.label}><span>{r.label}</span><b>{r.count}</b></li>) : <li><span>자료 없음</span></li>}</ol>
                  </article>
                ))}
              </div>
            )}
          </section>
        )}

        {!['summary', 'admins'].includes(tab) && (
          <div className="filter-bar">
            <input type="search" id="adminSearch" placeholder="아이디·이름·제목으로 찾기" value={query} onChange={e => setQuery(e.target.value)} />
            {tab === 'notices' && <button className="btn primary" id="newNoticeButton" onClick={() => noticeForm(null)}>+ 새 공지</button>}
          </div>
        )}

        {tab === 'users' && (
          <div className="table-wrap">
            <table>
              <thead><tr><th>아이디</th><th>닉네임 / 이름</th><th>전화번호</th><th>물품 / 신청</th><th>상태</th><th>관리</th></tr></thead>
              <tbody id="adminUserRows">
                {users.filter(u => match(u.id, u.nickname, u.name, u.phone)).map(u => (
                  <tr key={u.id} data-user-id={u.id}>
                    <td><b>{u.id}</b></td>
                    <td>{u.nickname} / {u.name}</td>
                    <td>{u.withdrawn ? '—' : u.phone}</td>
                    <td>{u.itemCount} / {u.rentalCount}</td>
                    <td>
                      {u.withdrawn ? <span className="status-chip">탈퇴</span>
                        : u.suspended ? <span className="status-chip danger-chip">이용 정지</span>
                        : u.locked ? <span className="status-chip pending">로그인 잠김</span>
                        : <span className="status-chip available">정상</span>}
                      <small>{u.withdrawn ? '기록만 보존 중' : u.suspended ? `사유: ${u.suspendReason}` : `접속 중 ${u.sessions}`}</small>
                    </td>
                    <td className="action-cell">
                      {!u.withdrawn && (
                        <>
                          <button className="table-action" onClick={() => editUser(u)}>정보 수정</button>
                          <button className="table-action" onClick={() => resetPassword(u)}>임시 비밀번호</button>
                          {u.suspended
                            ? <button className="table-action" onClick={() => runAction(`${u.id} 회원의 이용 정지를 해제할까요?`, '/api/admin/users/unsuspend', { userId: u.id }, 'users')}>정지 해제</button>
                            : <button className="table-action danger" onClick={() => suspendUser(u)}>이용 정지</button>}
                          {u.locked && <button className="table-action" onClick={() => runAction(null, '/api/admin/users/unlock', { userId: u.id }, 'users')}>잠금 해제</button>}
                          {u.sessions > 0 && <button className="table-action danger" onClick={() => runAction(`${u.id} 회원을 모든 기기에서 로그아웃시킬까요?`, '/api/admin/users/logout', { userId: u.id }, 'users')}>강제 로그아웃</button>}
                          <button className="table-action danger" onClick={() => withdrawUser(u)}>탈퇴 처리</button>
                        </>
                      )}
                      <button className="table-action danger" onClick={() => deleteUser(u)}>완전 삭제</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {tab === 'items' && (
          <div className="table-wrap">
            <table>
              <thead><tr><th>번호</th><th>물품</th><th>등록자</th><th>상태</th><th>대여 글 / 진행 중</th><th>관리</th></tr></thead>
              <tbody id="adminItemRows">
                {items.filter(it => match(it.itemNum, it.itemName, it.lenderId, it.category)).map(it => (
                  <tr key={it.itemNum} data-item-num={it.itemNum}>
                    <td>{it.itemNum}</td>
                    <td>
                      <div className="item-cell">
                        <ItemPhoto itemNum={it.itemNum} version={it.imageVersion} category={it.category} alt={it.itemName} className="item-thumb" />
                        <div><b>{it.itemName}</b><small>{it.category}</small>{it.imageCredit && <small className="photo-credit-text">사진: {it.imageCredit}</small>}</div>
                      </div>
                    </td>
                    <td>{it.lenderId}</td>
                    <td><span className={`status-chip ${it.available ? 'available' : 'renting'}`}>{it.available ? '대여 가능' : '대여 중'}</span></td>
                    <td>{it.postCount ? '있음' : '없음'} / {it.activeRentals}건</td>
                    <td className="action-cell">
                      <button className="table-action" onClick={() => editItem(it)}>수정</button>
                      <label className="table-action file-action">
                        {it.imageVersion ? '사진 변경' : '사진 등록'}
                        <input type="file" accept="image/*" onChange={e => adminPhoto(it, e)} />
                      </label>
                      {it.imageVersion > 0 && (
                        <button className="table-action danger" onClick={() => runAction(`${it.itemName} 의 사진을 삭제할까요?`, '/api/admin/items/image/delete', { itemNum: it.itemNum }, 'items')}>사진 삭제</button>
                      )}
                      {!it.available && it.activeRentals === 0 && (
                        <button className="table-action" onClick={() => runAction(`${it.itemName} 을(를) 대여 가능 상태로 되돌릴까요?`, '/api/admin/items/restore', { itemNum: it.itemNum }, 'items')}>상태 복구</button>
                      )}
                      <button className="table-action danger" onClick={() => runAction(`${it.itemNum}번 물품 "${it.itemName}" 을(를) 삭제할까요?`, '/api/admin/items/delete', { itemNum: it.itemNum }, 'items')}>삭제</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {tab === 'categories' && (
          <>
            <form className="filter-bar" id="addBigCategoryForm" onSubmit={addBig}>
              <input id="newBigCategory" placeholder="새 대분류 이름 (10자 이내)" maxLength={10} required value={newBigName} onChange={e => setNewBigName(e.target.value)} />
              <button className="btn primary" type="submit">대분류 추가</button>
            </form>
            <form className="filter-bar" id="addSmallCategoryForm" onSubmit={addSmall}>
              <select id="newSmallBig" required value={newSmall.bigCode} onChange={e => setNewSmall(prev => ({ ...prev, bigCode: e.target.value }))}>
                <option value="">대분류 선택</option>
                {categoryGroups.map(g => <option key={g.bigCode} value={g.bigCode}>{g.bigName}</option>)}
              </select>
              <input id="newSmallCategory" placeholder="새 소분류 이름 (10자 이내)" maxLength={10} required value={newSmall.name} onChange={e => setNewSmall(prev => ({ ...prev, name: e.target.value }))} />
              <button className="btn primary" type="submit">소분류 추가</button>
            </form>
            <div className="table-wrap">
              <table>
                <thead><tr><th>대분류</th><th>소분류 (등록 물품 수)</th><th>관리</th></tr></thead>
                <tbody id="adminCategoryRows">
                  {categoryGroups.filter(g => match(g.bigName, ...g.smalls.map(s => s.smallName))).map(g => (
                    <tr key={g.bigCode} data-big-code={g.bigCode}>
                      <td><b>{g.bigName}</b><small>{g.bigCode}</small></td>
                      <td>
                        {g.smalls.length ? g.smalls.map(s => (
                          <span key={s.smallCode} className="category-chip">
                            {s.smallName} <em>{s.itemCount}</em>
                            {s.itemCount === 0 && (
                              <button type="button" aria-label={`${s.smallName} 삭제`} onClick={() => runAction(`소분류 "${s.smallName}" 을(를) 삭제할까요?`, '/api/admin/categories/small/delete', { code: s.smallCode }, 'categories')}>×</button>
                            )}
                          </span>
                        )) : <small>소분류 없음</small>}
                      </td>
                      <td>
                        {g.smalls.length === 0 && (
                          <button className="table-action danger" onClick={() => runAction(`대분류 "${g.bigName}" 을(를) 삭제할까요?`, '/api/admin/categories/big/delete', { code: g.bigCode }, 'categories')}>삭제</button>
                        )}
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </>
        )}

        {tab === 'posts' && (
          <div className="table-wrap">
            <table>
              <thead><tr><th>번호</th><th>게시글</th><th>등록자</th><th>대여 기간</th><th>상태</th><th>관리</th></tr></thead>
              <tbody id="adminPostRows">
                {posts.filter(p => match(p.postNum, p.title, p.itemName, p.lenderId, p.addr)).map(p => (
                  <tr key={p.postNum} data-post-num={p.postNum}>
                    <td>{p.postNum}</td>
                    <td><b>{p.title}</b><small>{p.itemName} · {p.addr}</small></td>
                    <td>{p.lenderId}</td>
                    <td>{shortDate(p.rentDate)} ~ {shortDate(p.returnDate)}</td>
                    <td>
                      <span className={`status-chip ${p.available ? 'available' : 'renting'}`}>{p.available ? '대여 가능' : '대여 중'}</span>
                      <small>대여 내역 {p.rentalCount}건</small>
                    </td>
                    <td className="action-cell">
                      <button className="table-action" onClick={() => editPost(p)}>수정</button>
                      <button className="table-action danger" onClick={() => runAction(`${p.postNum}번 게시글 "${p.title}" 을(를) 삭제하시겠습니까?`, '/api/admin/posts/delete', { postNum: p.postNum }, 'posts')}>삭제</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {tab === 'rentals' && (
          <div className="segmented admin-segmented" id="adminRentalFilters">
            {rentalStatusFilters.map(f => (
              <button key={f.key} type="button" className={rentalFilter === f.key ? 'active' : undefined} onClick={() => setRentalFilter(f.key)}>
                {f.label} <span>{rentals.filter(r => !f.codes || f.codes.includes(r.status)).length}</span>
              </button>
            ))}
          </div>
        )}

        {tab === 'rentals' && (
          <div className="table-wrap">
            <table>
              <thead><tr><th>번호</th><th>물품</th><th>빌려준 회원</th><th>빌린 회원</th><th>상태</th><th>관리</th></tr></thead>
              <tbody id="adminRentalRows">
                {rentals
                  .filter(r => { const f = rentalStatusFilters.find(x => x.key === rentalFilter); return !f.codes || f.codes.includes(r.status) })
                  .filter(r => match(r.rentalNum, r.itemName, r.lenderId, r.borrowerId, r.statusName)).map(r => (
                  <tr key={r.rentalNum} data-rental-num={r.rentalNum}>
                    <td>{r.rentalNum}</td>
                    <td><b>{r.itemName}</b><small>게시글 {r.postNum}번</small></td>
                    <td>{r.lenderId}</td>
                    <td>{r.borrowerId}</td>
                    <td><span className="status-chip renting">{r.statusName}</span></td>
                    <td className="action-cell">
                      {r.status === 100 && <button className="table-action danger" onClick={() => runAction(`${r.rentalNum}번 대여 신청을 거절 처리하시겠습니까?`, '/api/admin/rentals/reject', { rentalNum: r.rentalNum }, 'rentals')}>거절 처리</button>}
                      {inProgress(r.status) && (
                        <>
                          <button className="table-action" onClick={() => runAction(`${r.rentalNum}번 대여를 강제로 완료 처리할까요? 물품은 대여 가능 상태로 돌아갑니다.`, '/api/admin/rentals/force-complete', { rentalNum: r.rentalNum }, 'rentals')}>강제 완료</button>
                          <button className="table-action danger" onClick={() => runAction(`${r.rentalNum}번 대여를 강제로 취소할까요? 물품은 대여 가능 상태로 돌아갑니다.`, '/api/admin/rentals/force-cancel', { rentalNum: r.rentalNum }, 'rentals')}>강제 취소</button>
                        </>
                      )}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {tab === 'notices' && (
          <div className="table-wrap">
            <table>
              <thead><tr><th>번호</th><th>공지</th><th>작성</th><th>상태</th><th>관리</th></tr></thead>
              <tbody id="adminNoticeRows">
                {notices.filter(n => match(n.title, n.content, n.adminId)).map(n => (
                  <tr key={n.noticeNum} data-notice-num={n.noticeNum}>
                    <td>{n.noticeNum}</td>
                    <td><b>{n.title}</b><small>{n.content.length > 60 ? n.content.slice(0, 60) + '…' : n.content}</small></td>
                    <td>{n.adminId}<small>{shortDate(n.updateAt)}</small></td>
                    <td><span className={`status-chip ${n.active ? 'available' : 'renting'}`}>{n.active ? '게시 중' : '내림'}</span></td>
                    <td className="action-cell">
                      <button className="table-action" onClick={() => noticeForm(n)}>수정</button>
                      <button className="table-action" onClick={() => runAction(null, '/api/admin/notices/toggle', { noticeNum: n.noticeNum, active: String(!n.active) }, 'notices')}>{n.active ? '내리기' : '게시'}</button>
                      <button className="table-action danger" onClick={() => runAction(`"${n.title}" 공지를 삭제할까요?`, '/api/admin/notices/delete', { noticeNum: n.noticeNum }, 'notices')}>삭제</button>
                    </td>
                  </tr>
                ))}
                {notices.length === 0 && <tr><td colSpan={5}>등록된 공지가 없습니다.</td></tr>}
              </tbody>
            </table>
          </div>
        )}

        {tab === 'admins' && (
          <>
            <div className="filter-bar">
              <button className="btn primary" id="addAdminButton" onClick={addAdmin}>+ 관리자 추가</button>
              <button className="btn outline" id="changeAdminPassword" onClick={changeMyPassword}>내 비밀번호 변경</button>
            </div>
            <div className="table-wrap">
              <table>
                <thead><tr><th>아이디</th><th>이름</th><th>접속 중</th><th>관리</th></tr></thead>
                <tbody id="adminAccountRows">
                  {admins.admins.map(a => (
                    <tr key={a.id} data-admin-id={a.id}>
                      <td><b>{a.id}</b>{a.id === admins.me && <small>나</small>}</td>
                      <td>{a.name}</td>
                      <td>{a.sessions}</td>
                      <td>{a.id !== admins.me && (
                        <button className="table-action danger" onClick={() => runAction(`관리자 ${a.id} 을(를) 삭제할까요?`, '/api/admin/admins/delete', { adminId: a.id }, 'admins')}>삭제</button>
                      )}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </>
        )}

        {tab === 'logs' && (
          <div className="table-wrap">
            <table>
              <thead><tr><th>시각</th><th>관리자</th><th>작업</th><th>대상</th><th>결과</th></tr></thead>
              <tbody id="adminLogRows">
                {logs.filter(l => match(l.adminId, l.action, l.detail, l.ip)).map(l => (
                  <tr key={l.logNum}>
                    <td>{shortDate(l.createAt)}</td>
                    <td><b>{l.adminId}</b><small>{l.ip}</small></td>
                    <td>{l.action}</td>
                    <td>{l.detail || '-'}</td>
                    <td><span className={`status-chip ${l.result < 300 ? 'available' : 'pending'}`}>{l.result < 300 ? '성공' : `실패 ${l.result}`}</span></td>
                  </tr>
                ))}
                {logs.length === 0 && <tr><td colSpan={5}>기록이 없습니다.</td></tr>}
              </tbody>
            </table>
          </div>
        )}
      </main>

      <FormModal
        open={form !== null}
        eyebrow={form?.eyebrow ?? 'ADMIN'}
        title={form?.title}
        description={form?.description}
        fields={form?.fields}
        submitLabel={form?.submitLabel}
        onSubmit={submitForm}
        onClose={() => setForm(null)}
      />
    </section>
  )
}
