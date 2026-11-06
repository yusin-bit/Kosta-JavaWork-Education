import { useEffect, useState } from 'react'
import { imageUrl } from '../../api'
import { categoryInfo, iconFor } from '../../constants'
import { compressImage } from '../../imageUtils'
import useDialog from './useDialog'

const firstSmallCode = big => big?.children[0]?.code ?? ''

// 물품 등록/수정 모달. item 이 있으면 수정, 없으면 등록.
export default function ItemModal({ open, item, categoryTree, onClose, onSubmit }) {
  const dialogRef = useDialog(open)
  const [itemName, setItemName] = useState('')
  const [bigCode, setBigCode] = useState('')
  const [smallCode, setSmallCode] = useState('')
  // 사진: photo = 새로 고른 사진(압축된 Blob), removePhoto = 기존 사진 지우기
  const [photo, setPhoto] = useState(null)
  const [photoPreview, setPhotoPreview] = useState(null)
  const [removePhoto, setRemovePhoto] = useState(false)
  const [photoError, setPhotoError] = useState('')
  const [compressing, setCompressing] = useState(false)

  // 카테고리를 불러오면 첫 번째 대분류/소분류를 기본 선택
  useEffect(() => {
    if (!categoryTree) return
    setBigCode(categoryTree[0]?.code ?? '')
    setSmallCode(firstSmallCode(categoryTree[0]))
  }, [categoryTree])

  // 모달이 열릴 때 폼 채우기 (원본 openItemForm)
  useEffect(() => {
    if (!open) return
    setPhoto(null)
    setPhotoPreview(null)
    setRemovePhoto(false)
    setPhotoError('')
    if (item) {
      setItemName(item.itemName)
      const category = categoryInfo(categoryTree, item.smallCategoryCode)
      if (category) {
        setBigCode(category.big.code)
        setSmallCode(item.smallCategoryCode)
      }
    } else {
      setItemName('')
      if (categoryTree?.length) {
        setBigCode(categoryTree[0].code)
        setSmallCode(firstSmallCode(categoryTree[0]))
      }
    }
  }, [open, item])

  const big = categoryTree?.find(category => category.code === bigCode)

  const changeBig = e => {
    const code = e.target.value
    setBigCode(code)
    setSmallCode(firstSmallCode(categoryTree.find(category => category.code === code)))
  }

  // 미리보기 주소는 다 쓰면 해제 (메모리 정리)
  useEffect(() => () => { if (photoPreview) URL.revokeObjectURL(photoPreview) }, [photoPreview])

  const choosePhoto = async e => {
    const file = e.target.files?.[0]
    e.target.value = ''
    if (!file) return
    setPhotoError('')
    setCompressing(true)
    try {
      const blob = await compressImage(file)
      setPhoto(blob)
      setPhotoPreview(URL.createObjectURL(blob))
      setRemovePhoto(false)
    } catch (error) {
      setPhotoError(error.message)
    } finally {
      setCompressing(false)
    }
  }

  const clearPhoto = () => {
    setPhoto(null)
    setPhotoPreview(null)
    setRemovePhoto(Boolean(item?.imageVersion))
  }

  const currentPhoto = photoPreview ?? (!removePhoto && item ? imageUrl(item.itemNum, item.imageVersion) : null)
  const smallName = big?.children.find(child => child.code === smallCode)?.name

  const handleSubmit = e => {
    e.preventDefault()
    if (compressing) return
    onSubmit({ itemName: itemName.trim(), smallCategoryCode: smallCode }, item?.itemNum, { photo, removePhoto })
  }

  return (
    <dialog id="itemModal" ref={dialogRef} onClose={onClose}>
      <form className="modal-card" id="itemForm" onSubmit={handleSubmit}>
        <button className="modal-close" type="button" id="closeItemModal" aria-label="닫기" onClick={onClose}>×</button>
        <p className="eyebrow">MY ITEM</p>
        <h3 id="itemModalTitle">{item ? '물품 수정' : '물품 등록'}</h3>
        <label>물품명<input id="itemName" type="text" placeholder="예: 무선 빔프로젝터" required maxLength={100} value={itemName} onChange={e => setItemName(e.target.value)} /></label>
        <div className="field-row">
          <label>대분류
            <select id="itemBigCategory" value={bigCode} onChange={changeBig}>
              {categoryTree === null
                ? <option>불러오는 중...</option>
                : categoryTree.map(category => <option key={category.code} value={category.code}>{category.name}</option>)}
            </select>
          </label>
          <label>소분류
            <select
              id="itemSmallCategory"
              value={smallCode}
              onChange={e => setSmallCode(e.target.value)}
              disabled={categoryTree !== null && (!big || !big.children.length)}
            >
              {categoryTree === null
                ? <option>대분류를 선택하세요</option>
                : big
                  ? big.children.map(child => <option key={child.code} value={child.code}>{child.name}</option>)
                  : <option value="">소분류 없음</option>}
            </select>
          </label>
        </div>
        <div className="photo-field">
          <span className="photo-label">물품 사진 (선택)</span>
          <div className="photo-picker">
            {currentPhoto
              ? <img className="photo-preview" id="itemPhotoPreview" src={currentPhoto} alt="물품 사진 미리보기" />
              : <span className="photo-preview placeholder" aria-hidden="true">{iconFor(smallName)}</span>}
            <div className="photo-buttons">
              <label className="btn outline photo-choose">
                {compressing ? '사진 줄이는 중...' : currentPhoto ? '사진 바꾸기' : '사진 선택'}
                <input id="itemPhoto" type="file" accept="image/jpeg,image/png,image/webp,image/heic,image/*" onChange={choosePhoto} disabled={compressing} />
              </label>
              {currentPhoto && <button type="button" className="table-action danger" id="removeItemPhoto" onClick={clearPhoto}>사진 빼기</button>}
              <small>JPG·PNG, 큰 사진은 자동으로 줄여서 올립니다.</small>
            </div>
          </div>
          {photoError && <small className="photo-error" role="alert">{photoError}</small>}
        </div>
        <p className="modal-desc">등록한 물품은 내 물품 관리에서 조회·수정·삭제할 수 있습니다.</p>
        <button className="btn primary wide" id="itemSubmitButton" type="submit" disabled={compressing}>{item ? '수정 완료' : '등록하기'}</button>
      </form>
    </dialog>
  )
}
