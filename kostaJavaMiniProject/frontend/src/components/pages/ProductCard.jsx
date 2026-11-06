import ItemPhoto from '../ItemPhoto'

// compact=true 면 메인 화면용(신청 버튼 없음), own=true 면 내가 올린 글(신청 불가)
export default function ProductCard({ product: p, compact = false, own = false, onRent }) {
  return (
    <article className="product-card" data-name={`${p.itemName} ${p.category}`}>
      <div className="product-visual">
        <ItemPhoto itemNum={p.imageItemNum} version={p.imageVersion} category={p.category} alt={p.itemName} />
        {p.imageCredit && <small className="photo-credit">{p.imageCredit}</small>}
      </div>
      <div className="product-info">
        <div className="product-meta"><span>{p.category || '미분류'}</span></div>
        <h4>{p.itemName}</h4>
        <p>{p.title || p.content || '등록된 대여 물품'}</p>
        <div className="product-actions">
          <span className="status-chip available">대여 가능</span>
          {!compact && (own
            ? <span className="status-chip pending">내 글</span>
            : <button className="btn primary rent-button" onClick={() => onRent(p)}>신청</button>)}
        </div>
      </div>
    </article>
  )
}
