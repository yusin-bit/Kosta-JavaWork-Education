import { useState } from 'react'

// 관리자 로그인: 일반 로그인 화면과 같은 레이아웃(auth-shell)을 쓴다
export default function AdminLoginView({ onLogin, onBack }) {
  const [id, setId] = useState('')
  const [password, setPassword] = useState('')

  const handleSubmit = e => {
    e.preventDefault()
    onLogin(id, password)
  }

  return (
    <section className="auth-shell" id="adminLoginView">
      <aside className="auth-brand">
        <a className="brand brand-light" href="#">빌림<span>.</span></a>
        <div className="brand-copy">
          <p className="eyebrow">ADMIN CONSOLE</p>
          <h1>서비스를<br />관리합니다.</h1>
          <p>회원·게시글·대여 현황을 확인하고, 문제가 되는 게시글이나 신청을 정리할 수 있습니다.</p>
        </div>
        <div className="brand-stats" />
      </aside>
      <main className="auth-panel">
        <div className="auth-card">
          <form className="auth-form active" id="adminLoginForm" onSubmit={handleSubmit}>
            <div className="form-heading admin-heading"><p>관리자 전용</p><h2>관리자 로그인</h2></div>
            <label>관리자 아이디<input type="text" placeholder="관리자 아이디" autoComplete="username" required value={id} onChange={e => setId(e.target.value)} /></label>
            <label>비밀번호<input type="password" placeholder="비밀번호" autoComplete="current-password" required value={password} onChange={e => setPassword(e.target.value)} /></label>
            <button className="btn primary wide" type="submit">관리자 로그인</button>
            <p className="form-note">회원 계정으로는 로그인할 수 없습니다.</p>
          </form>
        </div>
        <button className="exit-link" type="button" onClick={onBack}>← 회원 로그인으로</button>
      </main>
    </section>
  )
}
