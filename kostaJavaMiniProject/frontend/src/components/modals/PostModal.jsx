import { useEffect, useState } from 'react'
import useDialog from './useDialog'

const EMPTY_FORM = { title: '', content: '', rentDate: '', returnDate: '', addr: '' }
// DB 의 "2026-10-08 10:00:00" → <input type="datetime-local"> 형식 "2026-10-08T10:00"
const toInputDate = value => (value ? value.replace(' ', 'T').slice(0, 16) : '')

// 대여 글(게시글) 등록/수정 모달. post 가 있으면 수정, 없으면 item 에 새 글 등록.
// 입력 규칙은 콘솔 PostMenuView 와 같다: 제목 1~50자, 설명 필수, 주소 1~255자, 반납일 > 대여일
export default function PostModal({ open, item, post, onClose, onSubmit }) {
  const dialogRef = useDialog(open)
  const [form, setForm] = useState(EMPTY_FORM)
  const update = field => e => setForm(prev => ({ ...prev, [field]: e.target.value }))

  useEffect(() => {
    if (!open) return
    setForm(post
      ? { title: post.title, content: post.content, rentDate: toInputDate(post.rentDate), returnDate: toInputDate(post.returnDate), addr: post.addr }
      : EMPTY_FORM)
  }, [open, post])

  const handleSubmit = e => {
    e.preventDefault()
    const payload = {
      title: form.title.trim(),
      content: form.content.trim(),
      rentDate: form.rentDate,
      returnDate: form.returnDate,
      addr: form.addr.trim(),
    }
    onSubmit(post ? payload : { ...payload, itemNum: item.itemNum }, post?.postNum)
  }

  return (
    <dialog id="postModal" ref={dialogRef} onClose={onClose}>
      <form className="modal-card" id="postForm" onSubmit={handleSubmit}>
        <button className="modal-close" type="button" aria-label="닫기" onClick={onClose}>×</button>
        <p className="eyebrow">RENTAL POST</p>
        <h3 id="postModalTitle">{post ? '대여 글 수정' : '대여 글 올리기'}</h3>
        <p className="modal-desc">{item ? `「${item.itemName}」을(를) 다른 회원이 빌릴 수 있도록 대여 조건을 입력합니다.` : ''}</p>
        <label>제목<input id="postTitle" type="text" placeholder="예: 주말 캠핑용으로 빌려드려요" required maxLength={50} value={form.title} onChange={update('title')} /></label>
        <label>설명<textarea id="postContent" rows={3} placeholder="물품 상태, 구성품, 주의사항 등" required value={form.content} onChange={update('content')} /></label>
        <div className="field-row">
          <label>대여 시작<input id="postRentDate" type="datetime-local" required value={form.rentDate} onChange={update('rentDate')} /></label>
          <label>반납<input id="postReturnDate" type="datetime-local" required value={form.returnDate} onChange={update('returnDate')} /></label>
        </div>
        <label>거래 장소<input id="postAddr" type="text" placeholder="예: 서울특별시 마포구 합정역 2번 출구" required maxLength={255} value={form.addr} onChange={update('addr')} /></label>
        <button className="btn primary wide" id="postSubmitButton" type="submit">{post ? '수정 완료' : '대여 글 등록'}</button>
      </form>
    </dialog>
  )
}
