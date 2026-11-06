import { useState } from 'react'
import { api, requestOptions } from '../../api'
import { displayNameOf } from '../../constants'

const EMPTY_FORM = { currentPassword: '', newPassword: '', confirmation: '' }

export default function AccountPage({ active, user, toast }) {
  const [form, setForm] = useState(EMPTY_FORM)
  const update = field => e => setForm(prev => ({ ...prev, [field]: e.target.value }))
  const displayName = user ? displayNameOf(user) : null

  const handleSubmit = async e => {
    e.preventDefault()
    const { currentPassword, newPassword, confirmation } = form
    if (newPassword !== confirmation) {
      toast('새 비밀번호와 확인 값이 일치하지 않습니다.')
      return
    }
    try {
      const result = await api('/api/password', requestOptions({ currentPassword, newPassword, confirmation }))
      setForm(EMPTY_FORM)
      toast(result.message || '비밀번호가 변경되었습니다.')
    } catch (error) {
      toast(error.message)
    }
  }

  return (
    <section className={`page${active ? ' active' : ''}`} data-page-panel="account">
      <div className="section-row">
        <div><p className="eyebrow">MY ACCOUNT</p><h3>회원 정보 관리</h3><p>Java MenuView의 비밀번호 변경 기능을 웹 폼으로 표현했습니다.</p></div>
      </div>
      <form className="panel account-form" id="passwordForm" onSubmit={handleSubmit}>
        <div className="profile-large">
          <div className="avatar large" id="accountAvatar">{displayName ? displayName.slice(0, 1) : '-'}</div>
          <div>
            <h4 id="accountUserName">{displayName ?? '회원'}</h4>
            <p id="accountUserInfo">{user ? `${user.id} · ${user.phone}` : '로그인 정보를 불러오는 중입니다.'}</p>
          </div>
        </div>
        <label>현재 비밀번호<input id="currentPassword" type="password" placeholder="현재 비밀번호" autoComplete="current-password" required value={form.currentPassword} onChange={update('currentPassword')} /></label>
        <label>새 비밀번호<input id="newPassword" type="password" placeholder="새 비밀번호" autoComplete="new-password" maxLength={20} required value={form.newPassword} onChange={update('newPassword')} /></label>
        <label>새 비밀번호 확인<input id="confirmPassword" type="password" placeholder="한 번 더 입력" autoComplete="new-password" maxLength={20} required value={form.confirmation} onChange={update('confirmation')} /></label>
        <button className="btn primary" type="submit">비밀번호 변경</button>
      </form>
    </section>
  )
}
