import { useState } from 'react'

// 관리자가 게시한 공지를 회원 화면 맨 위에 보여준다. 제목을 누르면 내용이 펼쳐진다.
export default function NoticeBar({ notices, id = 'noticeBar' }) {
  const [openNum, setOpenNum] = useState(null)
  if (!notices || notices.length === 0) return null

  return (
    <section className="notice-bar" id={id} aria-label="공지사항">
      {notices.map(n => (
        <article key={n.noticeNum} className={`notice-item${openNum === n.noticeNum ? ' open' : ''}`}>
          <button type="button" onClick={() => setOpenNum(openNum === n.noticeNum ? null : n.noticeNum)} aria-expanded={openNum === n.noticeNum}>
            <span className="notice-tag">공지</span>
            <b>{n.title}</b>
            <i>{openNum === n.noticeNum ? '닫기' : '보기'}</i>
          </button>
          {openNum === n.noticeNum && <p>{n.content}</p>}
        </article>
      ))}
    </section>
  )
}
