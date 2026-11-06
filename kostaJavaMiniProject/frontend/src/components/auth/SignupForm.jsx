import { useState } from 'react'
import { api, requestOptions } from '../../api'

const EMPTY_FORM = { id: '', nickname: '', password: '', name: '', phone: '' }

export default function SignupForm({ active, toast, onDone }) {
  const [form, setForm] = useState(EMPTY_FORM)
  // 중복 확인을 통과한 아이디 (입력값이 바뀌면 다시 확인해야 함)
  const [checkedSignupId, setCheckedSignupId] = useState('')
  const [idStatus, setIdStatus] = useState({ text: '', type: '' })

  const update = field => e => setForm(prev => ({ ...prev, [field]: e.target.value }))

  const handleIdChange = e => {
    setForm(prev => ({ ...prev, id: e.target.value }))
    setCheckedSignupId('')
    setIdStatus({ text: '아이디 중복 확인이 필요합니다.', type: '' })
  }

  const checkSignupId = async () => {
    const id = form.id.trim()
    if (!id) {
      setIdStatus({ text: '아이디를 입력해주세요.', type: 'error' })
      setCheckedSignupId('')
      return false
    }
    try {
      const result = await api('/api/check-id', requestOptions({ id }))
      setIdStatus({ text: result.message, type: result.available ? 'success' : 'error' })
      setCheckedSignupId(result.available ? id : '')
      return result.available
    } catch (error) {
      setIdStatus({ text: error.message, type: 'error' })
      setCheckedSignupId('')
      return false
    }
  }

  const signUp = async () => {
    const id = form.id.trim()
    if (checkedSignupId !== id && !(await checkSignupId())) return
    try {
      const result = await api('/api/signup', requestOptions({
        id,
        nickname: form.nickname,
        password: form.password,
        name: form.name,
        phone: form.phone,
      }))
      setForm(EMPTY_FORM)
      setCheckedSignupId('')
      setIdStatus({ text: '', type: '' })
      toast(result.message)
      onDone()
    } catch (error) {
      toast(error.message)
      if (/아이디/.test(error.message)) {
        setCheckedSignupId('')
        setIdStatus({ text: error.message, type: 'error' })
      }
    }
  }

  return (
    <form className={`auth-form${active ? ' active' : ''}`} onSubmit={e => e.preventDefault()}>
      <div className="form-heading"><p>빌림을 시작해 보세요</p><h2>회원가입</h2></div>
      <div className="field-row">
        <label>아이디
          <div className="id-check-row">
            <input id="signupId" type="text" placeholder="사용할 아이디" maxLength={20} value={form.id} onChange={handleIdChange} />
            <button className="btn outline" id="checkSignupId" type="button" onClick={checkSignupId}>중복 확인</button>
          </div>
          <small className={`field-message${idStatus.type ? ` ${idStatus.type}` : ''}`} id="signupIdStatus">{idStatus.text}</small>
        </label>
        <label>닉네임<input type="text" placeholder="표시 이름" value={form.nickname} onChange={update('nickname')} /></label>
      </div>
      <label>비밀번호<input type="password" placeholder="4자 이상 입력" value={form.password} onChange={update('password')} /></label>
      <div className="field-row">
        <label>이름<input type="text" placeholder="홍길동" value={form.name} onChange={update('name')} /></label>
        <label>전화번호<input type="tel" placeholder="010-0000-0000" value={form.phone} onChange={update('phone')} /></label>
      </div>
      <button className="btn primary wide signup-action" type="button" onClick={signUp}>가입하기</button>
    </form>
  )
}
