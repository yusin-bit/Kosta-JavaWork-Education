import { rentalFilters } from '../../constants'
import ProductCard from './ProductCard'

const summaryCards = [
  { filter: 'requested', icon: '↗', color: 'blue', label: '대여 신청', link: '신청 내역 보기' },
  { filter: 'renting', icon: '◷', color: 'amber', label: '대여 중', link: '진행 내역 보기' },
  { filter: 'completed', icon: '✓', color: 'green', label: '완료 내역', link: '완료 내역 보기' },
]

export default function DashboardPage({ active, products, summaryRentals, showPage }) {
  // 내가 빌린(borrower) 대여 중 해당 상태인 건수
  const countFor = filterName =>
    summaryRentals.filter(r => r.role === 'borrower' && rentalFilters[filterName].statuses.includes(Number(r.status))).length

  return (
    <section className={`page${active ? ' active' : ''}`} data-page-panel="dashboard">
      <div className="hero-card">
        <div>
          <span className="status-chip light">현재 이용 현황</span>
          <h3>대여 생활을<br />한눈에 관리하세요.</h3>
          <p>신청부터 승인, 대여, 반납까지 하나의 흐름으로 이어집니다.</p>
        </div>
        <div className="hero-orbit" aria-hidden="true">
          <div className="orbit-card o1">신청<small>REQUESTED</small></div>
          <div className="orbit-card o2">대여<small>RENTING</small></div>
          <div className="orbit-card o3">반납<small>RETURNED</small></div>
          <div className="orbit-center"><span>⟳</span></div>
        </div>
      </div>

      <div className="summary-grid">
        {summaryCards.map(card => {
          const openHistory = () => showPage('history', card.filter)
          return (
            <article
              key={card.filter}
              className="summary-card"
              role="button"
              tabIndex={0}
              onClick={openHistory}
              onKeyDown={event => {
                if (event.key === 'Enter' || event.key === ' ') {
                  event.preventDefault()
                  openHistory()
                }
              }}
            >
              <span className={`summary-icon ${card.color}`}>{card.icon}</span>
              <div><small>{card.label}</small><strong>{countFor(card.filter)}</strong></div>
              <em>{card.link}</em>
            </article>
          )
        })}
      </div>

      <div className="section-row">
        <div><p className="eyebrow">AVAILABLE NOW</p><h3>지금 빌릴 수 있어요</h3></div>
        <button className="text-link" onClick={() => showPage('rent')}>전체 보기 →</button>
      </div>
      <div className="item-cards" id="dashboardItems">
        {products && (products.length
          ? products.slice(0, 3).map(p => <ProductCard key={p.postNum} product={p} compact />)
          : <p>대여 가능한 물품이 없습니다.</p>)}
      </div>
    </section>
  )
}
