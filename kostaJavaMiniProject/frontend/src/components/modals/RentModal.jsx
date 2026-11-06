import ItemPhoto from '../ItemPhoto'
import useDialog from './useDialog'

export default function RentModal({ open, product, onClose, onConfirm }) {
  const dialogRef = useDialog(open)

  return (
    <dialog id="rentModal" ref={dialogRef} onClose={onClose}>
      <form method="dialog" className="modal-card">
        {/* 브라우저의 close 이벤트에 기대지 않고 직접 상태를 닫는다 */}
        <button
          className="modal-close"
          value="cancel"
          aria-label="닫기"
          onClick={e => {
            e.preventDefault()
            onClose()
          }}
        >
          ×
        </button>
        <p className="eyebrow">RENTAL REQUEST</p>
        {product?.imageVersion > 0 && (
          <div className="rent-photo">
            <ItemPhoto itemNum={product.imageItemNum} version={product.imageVersion} category={product.category} alt={product.itemName} />
          </div>
        )}
        <h3 id="rentModalTitle">{product ? product.itemName : '대여 신청'}</h3>
        <p className="modal-desc">게시글에 등록된 대여 기간과 거래 장소 조건으로 신청합니다.</p>
        <button
          className="btn primary wide"
          id="confirmRent"
          value="cancel"
          onClick={e => {
            e.preventDefault()
            onConfirm()
          }}
        >
          대여 신청하기
        </button>
      </form>
    </dialog>
  )
}
