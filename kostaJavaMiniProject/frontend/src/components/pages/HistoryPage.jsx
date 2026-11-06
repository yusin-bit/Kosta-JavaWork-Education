import { Fragment, useState } from 'react'
import { rentalActionLabels } from '../../constants'
import RentalCard from './RentalCard'

const stages = [
  { key: 'stage-all', label: '전체' },
  { key: 'stage-requested', label: '신청' },
  { key: 'stage-approved', label: '승인' },
  { key: 'stage-rented', label: '대여 중' },
  { key: 'stage-returning', label: '반납 신청' },
  { key: 'stage-completed', label: '완료' },
]

export default function HistoryPage({ active, history, onSelectStage, onRentalAction }) {
  // 처리 중인 버튼 (중복 클릭 방지용) — "대여번호:액션"
  const [busyKey, setBusyKey] = useState(null)

  const handleAction = async (rentalNum, action) => {
    if (!confirm(`${rentalActionLabels[action]} 처리하시겠습니까?`)) return
    setBusyKey(`${rentalNum}:${action}`)
    await onRentalAction(rentalNum, action)
    setBusyKey(null)
  }

  return (
    <section className={`page${active ? ' active' : ''}`} data-page-panel="history">
      <div className="section-row">
        <div><p className="eyebrow">RENTAL HISTORY</p><h3 id="historyTitle">{history.title}</h3><p id="historyDescription">{history.description}</p></div>
      </div>

      <div className="flow-strip" aria-label="대여 상태 필터">
        {stages.map((stage, index) => (
          <Fragment key={stage.key}>
            {/* 원본처럼 '전체'와 '신청' 사이에는 화살표가 없다 */}
            {index >= 2 && <i>→</i>}
            <button className={history.filter === stage.key ? 'current' : undefined} type="button" onClick={() => onSelectStage(stage.key)}>{stage.label}</button>
          </Fragment>
        ))}
      </div>

      <div className="history-grid">
        {history.rentals && (history.rentals.length
          ? history.rentals.map(r => <RentalCard key={r.rentalNum} rental={r} busyKey={busyKey} onAction={handleAction} />)
          : <article className="panel"><h4>해당 단계의 내역이 없습니다.</h4><p>다른 상태를 선택해 확인해 보세요.</p></article>)}
      </div>
    </section>
  )
}
