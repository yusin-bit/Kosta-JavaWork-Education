import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import './styles.css'

// 다른 사이트가 이 화면을 iframe 으로 몰래 넣어 클릭을 유도하는 것(클릭재킹) 방지.
// GitHub Pages 는 X-Frame-Options 헤더를 설정할 수 없어서 화면에서 직접 막는다.
if (window.top !== window.self) {
  document.getElementById('root').textContent = '보안을 위해 빌림은 다른 사이트 안에서 열 수 없습니다.'
} else {
  createRoot(document.getElementById('root')).render(
    <StrictMode>
      <App />
    </StrictMode>,
  )
}
