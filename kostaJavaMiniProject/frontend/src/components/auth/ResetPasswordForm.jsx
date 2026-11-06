import { useState } from 'react'
import { api, requestOptions } from '../../api'

const EMPTY_FORM = { id: '', phone: '', newPassword: '', confirmation: '' }

export default function ResetPasswordForm({ active, toast, onDone }) {
  const [form, setForm] = useState(EMPTY_FORM)
  const update = field => e => setForm(prev => ({ ...prev, [field]: e.target.value }))

  const handleSubmit = async e => {
    e.preventDefault()
    const id = form.id.trim()
    const phone = form.phone.trim()
    const { newPassword, confirmation } = form
    if (newPassword !== confirmation) {
      toast('새 비밀번호와 확인 값이 일치하지 않습니다.')
      return
    }
    try {
      const result = await api('/api/password/reset', requestOptions({ id, phone, newPassword, confirmation }))
      setForm(EMPTY_FORM)
      toast(result.message)
      onDone()
    } catch (error) {
      toast(error.message)
    }
  }

  return (
    <form className={`auth-form${active ? ' active' : ''}`} id="resetPasswordForm" onSubmit={handleSubmit}>
      <div className="form-heading"><p>가입 정보를 확인하고 변경할게요</p><h2>비밀번호 변경</h2></div>
      <label>아이디<input id="resetUserId" type="text" placeholder="가입한 아이디" required maxLength={20} value={form.id} onChange={update('id')} /></label>
      <label>전화번호<input id="resetPhone" type="tel" placeholder="010-0000-0000" required value={form.phone} onChange={update('phone')} /></label>
      <label>새 비밀번호<input id="resetNewPassword" type="password" placeholder="새 비밀번호" autoComplete="new-password" required maxLength={20} value={form.newPassword} onChange={update('newPassword')} /></label>
      <label>새 비밀번호 확인<input id="resetPasswordConfirmation" type="password" placeholder="한 번 더 입력" autoComplete="new-password" required maxLength={20} value={form.confirmation} onChange={update('confirmation')} /></label>
      <button className="btn primary wide" type="submit">비밀번호 변경</button>
    </form>
  )
}
