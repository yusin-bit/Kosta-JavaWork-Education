import { useState } from 'react'

export default function LoginForm({ active, onLogin }) {
  const [id, setId] = useState('')
  const [password, setPassword] = useState('')

  const handleSubmit = e => {
    e.preventDefault()
    onLogin(id, password)
  }

  return (
    <form className={`auth-form${active ? ' active' : ''}`} id="loginForm" onSubmit={handleSubmit}>
      <div className="form-heading"><p>다시 만나 반가워요</p><h2>로그인</h2></div>
      <label>아이디<input type="text" placeholder="아이디" autoComplete="username" required value={id} onChange={e => setId(e.target.value)} /></label>
      <label>비밀번호<input type="password" placeholder="비밀번호" autoComplete="current-password" required value={password} onChange={e => setPassword(e.target.value)} /></label>
      <button className="btn primary wide" type="submit">로그인</button>
      <p className="form-note">MySQL에 등록된 실제 회원 계정으로 로그인합니다.</p>
    </form>
  )
}
