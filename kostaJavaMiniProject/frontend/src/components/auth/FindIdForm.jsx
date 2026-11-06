import { useState } from 'react'
import { api, requestOptions } from '../../api'

export default function FindIdForm({ active, toast }) {
  const [name, setName] = useState('')
  const [phone, setPhone] = useState('')

  // 원본과 동일하게 서버에는 전화번호만 보낸다.
  const findId = async () => {
    try {
      const result = await api('/api/find-id', requestOptions({ phone }))
      toast(`가입된 아이디: ${result.id}`)
    } catch (error) {
      toast(error.message)
    }
  }

  return (
    <form className={`auth-form${active ? ' active' : ''}`} onSubmit={e => e.preventDefault()}>
      <div className="form-heading"><p>가입 정보를 확인할게요</p><h2>아이디 찾기</h2></div>
      <label>이름<input type="text" placeholder="가입할 때 입력한 이름" value={name} onChange={e => setName(e.target.value)} /></label>
      <label>전화번호<input type="tel" placeholder="010-0000-0000" value={phone} onChange={e => setPhone(e.target.value)} /></label>
      <button className="btn primary wide find-action" type="button" onClick={findId}>아이디 확인</button>
    </form>
  )
}
