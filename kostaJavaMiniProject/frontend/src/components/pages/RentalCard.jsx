// 역할(빌려준 사람/빌린 사람)과 상태 코드에 따라 보여줄 버튼 목록
const actionsFor = r => {
  const status = Number(r.status)
  if (r.role === 'lender' && status === 100) return [
    { action: 'reject', label: '거절', className: 'btn danger' },
    { action: 'approve', label: '승인', className: 'btn primary' },
  ]
  if (r.role === 'lender' && status === 101) return [{ action: 'start', label: '물품 인도·대여 시작', className: 'btn primary' }]
  if (r.role === 'borrower' && status === 110) return [{ action: 'return-request', label: '반납 신청', className: 'btn primary' }]
  if (r.role === 'lender' && status === 200) return [{ action: 'return-approve', label: '반납 승인', className: 'btn primary' }]
  if (r.role === 'borrower' && status === 201) return [{ action: 'return-confirm', label: '반납 거래 확인', className: 'btn primary' }]
  if (r.role === 'lender' && status === 210) return [{ action: 'complete', label: '최종 반납 완료', className: 'btn primary' }]
  return []
}

export default function RentalCard({ rental: r, busyKey, onAction }) {
  const isLender = r.role === 'lender'
  const otherParty = isLender ? r.borrowerId : r.lenderId
  const actions = actionsFor(r)

  return (
    <article className="panel" data-rental-num={r.rentalNum}>
      <span className="history-role">{isLender ? '내 물품에 온 신청' : '내가 빌린 물품'}</span>
      <div className="panel-head">
        <div><small>{r.title || '대여 게시글'}</small><h4>{r.itemName || '물품 정보 없음'}</h4></div>
        <span className="status-chip renting">{r.statusName}</span>
      </div>
      <dl>
        <div><dt>{isLender ? '신청자' : '대여자'}</dt><dd>{otherParty}</dd></div>
        <div><dt>대여 기간</dt><dd>{r.rentDate || '-'} ~ {r.returnDate || '-'}</dd></div>
        <div><dt>거래 장소</dt><dd>{r.addr || '-'}</dd></div>
      </dl>
      {actions.length > 0 && (
        <div className="history-actions">
          {actions.map(a => (
            <button
              key={a.action}
              className={a.className}
              disabled={busyKey === `${r.rentalNum}:${a.action}`}
              onClick={() => onAction(r.rentalNum, a.action)}
            >
              {a.label}
            </button>
          ))}
        </div>
      )}
    </article>
  )
}
