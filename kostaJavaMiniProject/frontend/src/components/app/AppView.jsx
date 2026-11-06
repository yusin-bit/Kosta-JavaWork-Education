import Sidebar from './Sidebar'
import NoticeBar from '../NoticeBar'
import DashboardPage from '../pages/DashboardPage'
import ItemsPage from '../pages/ItemsPage'
import RentPage from '../pages/RentPage'
import HistoryPage from '../pages/HistoryPage'
import AccountPage from '../pages/AccountPage'

export default function AppView({
  hidden, user, activePage, pageTitle, showPage, onLogout, toast,
  categoryTree, products, myItems, myPosts, notices, summaryRentals, history,
  onSelectStage, onRentalAction, onCreateItem, onEditItem, onDeleteItem, onRent,
  onCreatePost, onEditPost, onDeletePost,
}) {
  return (
    <section className={`app-shell${hidden ? ' hidden' : ''}`} id="appView">
      <Sidebar user={user} activePage={activePage} showPage={showPage} onLogout={onLogout} />

      <main className="workspace">
        <NoticeBar notices={notices} id="appNoticeBar" />
        <header className="topbar">
          <div><p className="eyebrow">RENTAL SERVICE</p><h2 id="pageTitle">{pageTitle}</h2></div>
          <div className="top-actions">
            <button className="btn outline" onClick={() => showPage('rent')}>물품 둘러보기</button>
            {/* 휴대폰에서는 사이드바 프로필(로그아웃 포함)이 숨겨지므로 상단에 로그아웃을 둔다 */}
            <button className="topbar-logout mobile-only" onClick={onLogout}>로그아웃</button>
          </div>
        </header>

        {/* 원본처럼 모든 페이지를 그려 두고 active 클래스로만 전환 → 검색어 등 입력 상태가 유지됨 */}
        <DashboardPage active={activePage === 'dashboard'} products={products} summaryRentals={summaryRentals} showPage={showPage} />
        <ItemsPage
          active={activePage === 'items'}
          myItems={myItems}
          myPosts={myPosts}
          categoryTree={categoryTree}
          onCreate={onCreateItem}
          onEdit={onEditItem}
          onDelete={onDeleteItem}
          onCreatePost={onCreatePost}
          onEditPost={onEditPost}
          onDeletePost={onDeletePost}
        />
        <RentPage active={activePage === 'rent'} products={products} categoryTree={categoryTree} myPosts={myPosts} onRent={onRent} toast={toast} />
        <HistoryPage active={activePage === 'history'} history={history} onSelectStage={onSelectStage} onRentalAction={onRentalAction} />
        <AccountPage active={activePage === 'account'} user={user} toast={toast} />
      </main>
    </section>
  )
}
