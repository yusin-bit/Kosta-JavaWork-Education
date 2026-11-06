// Java LocalWebApplication 의 /api/* 와 통신하는 함수 (원본 app.js 의 api, requestOptions 그대로)

// 로컬(Java 서버가 화면도 같이 서빙)에서는 같은 주소로, GitHub Pages 배포본에서는 Render 서버 주소로 요청한다.
const API_BASE = import.meta.env.VITE_API_BASE ?? ''

// 로그인하면 서버가 준 토큰을 메모리에만 보관한다 (새로고침하면 로그아웃 상태 — 원본과 동일)
let authToken = null
export const setAuthToken = token => {
  authToken = token
}

export const api = async (path, options = {}) => {
  const headers = { ...options.headers }
  if (authToken) headers.Authorization = `Bearer ${authToken}`
  const response = await fetch(API_BASE + path, { ...options, headers })
  const data = await response.json()
  if (!response.ok) throw new Error(data.message || '요청 처리에 실패했습니다.')
  return data
}

// 물품 사진 주소. 목록 API 의 imageVersion(수정 시각)을 붙여 사진이 바뀌면 브라우저가 새로 받게 한다.
// <img> 는 토큰을 보낼 수 없어서 사진 보기 API 는 로그인 없이 열려 있다.
export const imageUrl = (itemNum, version) => version ? `${API_BASE}/api/items/image?itemNum=${itemNum}&v=${version}` : null

// 사진 업로드: 본문에 JPEG 파일을 그대로 보낸다 (path 예: /api/items/image?itemNum=3)
export const uploadImage = (path, blob) => api(path, { method: 'POST', headers: { 'Content-Type': 'image/jpeg' }, body: blob })

// Java 쪽이 x-www-form-urlencoded 로 파라미터를 읽기 때문에 POST 본문을 이 형식으로 만든다.
export const requestOptions = data => ({
  method: 'POST',
  headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' },
  body: new URLSearchParams(data).toString(),
})
