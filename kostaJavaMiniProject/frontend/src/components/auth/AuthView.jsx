import { useState } from 'react'
import LoginForm from './LoginForm'
import SignupForm from './SignupForm'
import FindIdForm from './FindIdForm'
import ResetPasswordForm from './ResetPasswordForm'

const tabs = [
  { key: 'login', label: '로그인' },
  { key: 'signup', label: '회원가입' },
  { key: 'find', label: '아이디 찾기' },
  { key: 'reset', label: '비밀번호 변경' },
]

export default function AuthView({ hidden, globalStats, onLogin, onAdmin, toast }) {
  const [activeTab, setActiveTab] = useState('login')
  const goLogin = () => setActiveTab('login')

  return (
    <section className={`auth-shell${hidden ? ' hidden' : ''}`} id="authView">
      <aside className="auth-brand">
        <a className="brand brand-light" href="#">빌림<span>.</span></a>
        <div className="brand-copy">
          <p className="eyebrow">BORROW BETTER</p>
          <h1>필요한 순간만<br />가볍게 빌려요.</h1>
          <p>Java 콘솔의 MenuView 흐름을 HTML과 CSS 화면으로 다시 구성했습니다.</p>
        </div>
        <div className="brand-stats">
          <div><strong id="globalAvailable">{globalStats.available}</strong><span>대여 가능</span></div>
          <div><strong id="globalActive">{globalStats.active}</strong><span>진행 중</span></div>
          <div><strong id="globalCompleted">{globalStats.completed}</strong><span>완료된 대여</span></div>
        </div>
      </aside>

      <main className="auth-panel">
        <div className="auth-card">
          <nav className="auth-tabs" aria-label="회원 메뉴">
            {tabs.map(tab => (
              <button
                key={tab.key}
                className={`tab${activeTab === tab.key ? ' active' : ''}`}
                onClick={() => setActiveTab(tab.key)}
              >
                {tab.label}
              </button>
            ))}
          </nav>

          {/* 원본처럼 네 폼을 모두 그려 두고 active 클래스로만 보이기/숨기기 → 탭을 옮겨도 입력값 유지 */}
          <LoginForm active={activeTab === 'login'} onLogin={onLogin} />
          <SignupForm active={activeTab === 'signup'} toast={toast} onDone={goLogin} />
          <FindIdForm active={activeTab === 'find'} toast={toast} />
          <ResetPasswordForm active={activeTab === 'reset'} toast={toast} onDone={goLogin} />
        </div>
        <button className="exit-link" id="exitDemo" onClick={() => window.close()}>프로그램 종료</button>
        <button className="admin-link" id="adminEntry" onClick={onAdmin}>관리자 로그인</button>
      </main>
    </section>
  )
}
