import { displayNameOf } from '../../constants'

// short: 휴대폰 하단 메뉴에 표시하는 짧은 이름
const navItems = [
  { page: 'dashboard', icon: '⌂', title: '메인 화면', sub: '오늘의 현황', short: '홈' },
  { page: 'items', icon: '▦', title: '1. 물품 관리', sub: '등록·조회·수정', short: '내 물품' },
  { page: 'rent', icon: '↗', title: '2. 물품 대여', sub: '목록·신청', short: '대여' },
  { page: 'history', icon: '↺', title: '3. 반납 및 대여 내역', sub: '승인·반납 관리', short: '내역' },
  { page: 'account', icon: '◎', title: '4. 회원 정보 관리', sub: '비밀번호 변경', short: '내 정보' },
]

export default function Sidebar({ user, activePage, showPage, onLogout }) {
  const displayName = user ? displayNameOf(user) : null

  return (
    <aside className="sidebar">
      <a className="brand" href="#">빌림<span>.</span></a>
      <nav className="main-nav" aria-label="메인 메뉴">
        {navItems.map(item => (
          <button
            key={item.page}
            className={`nav-item${activePage === item.page ? ' active' : ''}`}
            onClick={() => showPage(item.page)}
          >
            <span className="nav-icon">{item.icon}</span>
            <span><b>{item.title}</b><small>{item.sub}</small><i className="nav-short">{item.short}</i></span>
          </button>
        ))}
      </nav>
      <div className="sidebar-profile">
        <div className="avatar" id="sidebarAvatar">{displayName ? displayName.slice(0, 1) : '-'}</div>
        <div><b id="sidebarUserName">{displayName ? `${displayName}님` : '회원님'}</b><small id="sidebarUserId">{user ? user.id : '빌림 회원'}</small></div>
        <button id="logoutBtn" aria-label="로그아웃" onClick={onLogout}>↪</button>
      </div>
    </aside>
  )
}
