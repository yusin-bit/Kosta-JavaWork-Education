import { useEffect, useRef, useState } from 'react'
import { api, requestOptions, setAuthToken, uploadImage } from './api'
import { displayNameOf, pageTitles, rentalFilters, rentalStages } from './constants'
import AuthView from './components/auth/AuthView'
import AppView from './components/app/AppView'
import ItemModal from './components/modals/ItemModal'
import RentModal from './components/modals/RentModal'
import PostModal from './components/modals/PostModal'
import AdminLoginView from './components/admin/AdminLoginView'
import AdminView from './components/admin/AdminView'
import Toast from './components/Toast'
import NoticeBar from './components/NoticeBar'
import useTableLabels from './useTableLabels'

const EMPTY_STATS = { available: '-', active: '-', completed: '-' }

export default function App() {
  // 로그인한 회원 (null 이면 로그인 화면)
  const [user, setUser] = useState(null)
  const [globalStats, setGlobalStats] = useState(EMPTY_STATS)

  // DB 에서 불러오는 데이터 (null = 아직 불러오지 않음)
  const [categoryTree, setCategoryTree] = useState(null)
  const [products, setProducts] = useState(null)
  const [myItems, setMyItems] = useState([])
  const [myPosts, setMyPosts] = useState([])
  const [summaryRentals, setSummaryRentals] = useState([])

  // 관리자 화면: null(일반) / 'login'(관리자 로그인) / 관리자 정보(로그인 완료)
  const [adminMode, setAdminMode] = useState(null)
  // 관리자가 게시한 공지 (로그인 없이 조회 가능)
  const [notices, setNotices] = useState([])
  useTableLabels()

  // 화면 전환
  const [activePage, setActivePage] = useState('dashboard')
  const [pageTitle, setPageTitle] = useState('대여 현황')
  const [history, setHistory] = useState({
    filter: 'stage-all',
    title: '반납 및 대여 내역 관리',
    description: '내가 신청한 대여와 반납 진행 상황만 확인합니다.',
    rentals: null,
  })

  // 모달
  const [itemModal, setItemModal] = useState({ open: false, item: null })
  const [rentModal, setRentModal] = useState({ open: false, product: null })
  // 대여 글 등록/수정: item(대상 물품) + post(수정할 글, 등록이면 null)
  const [postModal, setPostModal] = useState({ open: false, item: null, post: null })

  // 토스트 메시지
  const [toastState, setToastState] = useState({ message: '', show: false })
  const toastTimer = useRef(null)
  const toast = message => {
    clearTimeout(toastTimer.current)
    setToastState({ message, show: true })
    toastTimer.current = setTimeout(() => setToastState(prev => ({ ...prev, show: false })), 2600)
  }

  // ---------- 데이터 불러오기 ----------
  const loadGlobalStats = async () => {
    try {
      const data = await api('/api/stats')
      setGlobalStats({ available: data.available, active: data.active, completed: data.completed })
    } catch {
      setGlobalStats(EMPTY_STATS)
    }
  }

  const loadNotices = async () => {
    try {
      setNotices((await api('/api/notices')).notices)
    } catch {
      // 공지를 못 불러와도 나머지 화면은 그대로 쓸 수 있다.
    }
  }

  const loadCategories = async () => {
    const data = await api('/api/categories')
    setCategoryTree(data.categories)
  }

  const loadPosts = async () => {
    try {
      const data = await api('/api/posts')
      setProducts(data.posts)
    } catch (e) {
      toast(e.message)
    }
  }

  const loadMyItems = async () => {
    try {
      const data = await api('/api/items/mine')
      setMyItems(data.items)
    } catch (e) {
      toast(e.message)
    }
  }

  const loadMyPosts = async () => {
    try {
      const data = await api('/api/posts/mine')
      setMyPosts(data.posts)
    } catch (e) {
      toast(e.message)
    }
  }

  const loadRentalSummary = async () => {
    try {
      const data = await api('/api/rentals/current')
      setSummaryRentals(data.rentals)
    } catch (e) {
      toast(e.message)
    }
  }

  const loadRentals = async (filterName = 'all') => {
    try {
      const data = await api('/api/rentals/current')
      const summaryFilter = rentalFilters[filterName]
      const isStage = Object.hasOwn(rentalStages, filterName)
      const stageStatuses = rentalStages[filterName]
      setSummaryRentals(data.rentals)

      let rentals = data.rentals
      let title = rentalFilters.all.title
      let description = rentalFilters.all.description
      if (summaryFilter) {
        title = summaryFilter.title
        description = summaryFilter.description
        if (summaryFilter.statuses) rentals = rentals.filter(r => summaryFilter.statuses.includes(Number(r.status)))
        if (summaryFilter.borrowerOnly) rentals = rentals.filter(r => r.role === 'borrower')
      } else if (isStage) {
        title = '반납 및 대여 내역 관리'
        description = '선택한 단계의 내가 빌린 물품과 내 물품 신청입니다.'
        if (stageStatuses) rentals = rentals.filter(r => stageStatuses.includes(Number(r.status)))
      }
      setHistory({ filter: filterName, title, description, rentals })
    } catch (e) {
      toast(e.message)
    }
  }

  // 처음 화면이 열릴 때: 전체 통계 + DB 연결 확인
  useEffect(() => {
    // 무료 서버는 쉬고 있으면 깨어나는 데 최대 1분 정도 걸리므로, 응답이 늦으면 안내한다
    const wakeNotice = setTimeout(() => toast('서버를 깨우는 중입니다. 최대 1분 정도 걸릴 수 있어요.'), 3000)
    loadGlobalStats()
    loadNotices()
    api('/api/health')
      .then(data => console.info('DB connected:', data.database))
      .catch(error => toast(error.message))
      .finally(() => clearTimeout(wakeNotice))
    return () => clearTimeout(wakeNotice)
  }, [])

  // ---------- 화면 이동 ----------
  const showPage = (name, historyFilter = 'stage-all') => {
    setActivePage(name)
    setPageTitle(pageTitles[name])
    if (name === 'history') loadRentals(historyFilter)
    if (name === 'items') {
      loadMyItems()
      loadMyPosts()
    }
    window.scrollTo({ top: 0, behavior: 'smooth' })
  }

  // ---------- 로그인 / 로그아웃 ----------
  const login = async (id, password) => {
    try {
      const data = await api('/api/login', requestOptions({ id, password }))
      setAuthToken(data.token)
      setUser(data.user)
      setPageTitle(`안녕하세요, ${displayNameOf(data.user)}님`)
      await loadCategories()
      await Promise.all([loadPosts(), loadMyItems(), loadMyPosts(), loadRentalSummary(), loadGlobalStats(), loadNotices()])
      toast('Java 로그인과 MySQL 조회가 완료되었습니다.')
    } catch (error) {
      toast(error.message)
    }
  }

  const logout = async () => {
    try {
      await api('/api/logout', requestOptions({}))
    } catch {
      // 로그아웃 요청이 실패해도 화면은 로그인으로 돌린다.
    }
    setAuthToken(null)
    setUser(null)
    setMyItems([])
    setMyPosts([])
    setProducts(null)
    toast('로그아웃되었습니다.')
  }

  // ---------- 물품 관리 ----------
  const saveItem = async (payload, itemNum, { photo, removePhoto } = {}) => {
    if (!payload.itemName || !payload.smallCategoryCode) {
      toast('물품명과 카테고리를 입력해주세요.')
      return
    }
    try {
      const result = await api(
        itemNum ? '/api/items/update' : '/api/items/create',
        requestOptions(itemNum ? { ...payload, itemNum } : payload),
      )
      setItemModal(prev => ({ ...prev, open: false }))
      // 물품이 저장된 뒤 사진을 올린다 (새 물품은 서버가 준 번호로). 사진만 실패해도 물품은 저장된 상태
      const savedNum = itemNum ?? result.itemNum
      let message = result.message
      try {
        if (photo && savedNum) {
          await uploadImage(`/api/items/image?itemNum=${savedNum}`, photo)
          message += ' 사진도 저장되었습니다.'
        } else if (removePhoto && savedNum) {
          await api('/api/items/image/delete', requestOptions({ itemNum: savedNum }))
          message += ' 사진을 뺐습니다.'
        }
      } catch (photoError) {
        message += ` (사진 저장 실패: ${photoError.message})`
      }
      toast(message)
      if (photo || removePhoto) loadPosts()
      await Promise.all([loadMyItems(), loadGlobalStats()])
      // 콘솔의 "새 물품 및 게시글 등록"처럼, 새 물품을 등록하면 바로 대여 글 작성 창을 연다
      if (!itemNum && result.itemNum) {
        setPostModal({ open: true, item: { itemNum: result.itemNum, itemName: payload.itemName }, post: null })
      }
    } catch (error) {
      toast(error.message)
    }
  }

  // ---------- 대여 글(게시글) ----------
  const savePost = async (payload, postNum) => {
    try {
      const result = await api(
        postNum ? '/api/posts/update' : '/api/posts/create',
        requestOptions(postNum ? { ...payload, postNum } : payload),
      )
      setPostModal(prev => ({ ...prev, open: false }))
      toast(result.message)
      await Promise.all([loadMyPosts(), loadPosts(), loadGlobalStats()])
    } catch (error) {
      toast(error.message)
    }
  }

  const deletePost = async post => {
    if (!confirm(`"${post.title}" 대여 글을 삭제하시겠습니까?`)) return
    try {
      const result = await api('/api/posts/delete', requestOptions({ postNum: post.postNum }))
      toast(result.message)
      await Promise.all([loadMyPosts(), loadPosts(), loadGlobalStats()])
    } catch (error) {
      toast(error.message)
    }
  }

  // ---------- 관리자 ----------
  const adminLogin = async (id, password) => {
    try {
      const data = await api('/api/admin/login', requestOptions({ id, password }))
      setAuthToken(data.token)
      setAdminMode(data.admin)
      toast(`${data.admin.name}(관리자)로 로그인했습니다.`)
    } catch (error) {
      toast(error.message)
    }
  }

  const adminLogout = async () => {
    try {
      await api('/api/admin/logout', requestOptions({}))
    } catch {
      // 실패해도 화면은 로그인으로 돌린다.
    }
    setAuthToken(null)
    setAdminMode(null)
    loadNotices()
    toast('관리자 로그아웃되었습니다.')
  }

  const deleteItem = async item => {
    if (!confirm(`${item.itemName} 물품을 삭제하시겠습니까?`)) return
    try {
      const result = await api('/api/items/delete', requestOptions({ itemNum: item.itemNum }))
      toast(result.message)
      await Promise.all([loadMyItems(), loadGlobalStats(), loadPosts()])
    } catch (error) {
      toast(error.message)
    }
  }

  // ---------- 대여 ----------
  const requestRental = async () => {
    try {
      const result = await api('/api/rentals', requestOptions({ postNum: rentModal.product.postNum }))
      setRentModal(prev => ({ ...prev, open: false }))
      toast(result.message)
      await loadPosts()
      await loadGlobalStats()
      showPage('history', 'requested')
    } catch (error) {
      toast(error.message)
    }
  }

  const runRentalAction = async (rentalNum, action) => {
    try {
      const result = await api('/api/rentals/action', requestOptions({ rentalNum, action }))
      toast(result.message)
      await loadRentals(history.filter)
      await loadRentalSummary()
      await loadPosts()
      await loadGlobalStats()
    } catch (error) {
      toast(error.message)
    }
  }

  return (
    <>
      <div className="demo-banner"><strong>Java · MySQL 로컬 연동</strong><span>회원·물품·대여 정보는 Java Service와 Repository를 통해 DB에서 처리됩니다.</span></div>

      {/* 로그인 전에는 화면 맨 위, 로그인 후에는 본문 영역(AppView) 안에 공지를 보여준다 */}
      {adminMode === null && user === null && <NoticeBar notices={notices} />}
      {adminMode === 'login' && <AdminLoginView onLogin={adminLogin} onBack={() => setAdminMode(null)} />}
      {adminMode && adminMode !== 'login' && <AdminView admin={adminMode} onLogout={adminLogout} toast={toast} />}

      <AuthView
        hidden={user !== null || adminMode !== null}
        globalStats={globalStats}
        onLogin={login}
        onAdmin={() => setAdminMode('login')}
        toast={toast}
      />

      <AppView
        hidden={user === null || adminMode !== null}
        user={user}
        activePage={activePage}
        pageTitle={pageTitle}
        showPage={showPage}
        onLogout={logout}
        toast={toast}
        categoryTree={categoryTree}
        products={products}
        myItems={myItems}
        myPosts={myPosts}
        notices={notices}
        onCreatePost={item => setPostModal({ open: true, item, post: null })}
        onEditPost={(item, post) => setPostModal({ open: true, item, post })}
        onDeletePost={deletePost}
        summaryRentals={summaryRentals}
        history={history}
        onSelectStage={loadRentals}
        onRentalAction={runRentalAction}
        onCreateItem={() => setItemModal({ open: true, item: null })}
        onEditItem={item => setItemModal({ open: true, item })}
        onDeleteItem={deleteItem}
        onRent={product => setRentModal({ open: true, product })}
      />

      <ItemModal
        open={itemModal.open}
        item={itemModal.item}
        categoryTree={categoryTree}
        onClose={() => setItemModal(prev => ({ ...prev, open: false }))}
        onSubmit={saveItem}
      />
      <RentModal
        open={rentModal.open}
        product={rentModal.product}
        onClose={() => setRentModal(prev => ({ ...prev, open: false }))}
        onConfirm={requestRental}
      />
      <PostModal
        open={postModal.open}
        item={postModal.item}
        post={postModal.post}
        onClose={() => setPostModal(prev => ({ ...prev, open: false }))}
        onSubmit={savePost}
      />
      <Toast message={toastState.message} show={toastState.show} />
    </>
  )
}
