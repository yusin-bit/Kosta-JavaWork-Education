# 빌림 프론트엔드 (React)

기존 `web/` 의 HTML·CSS·JS 화면을 내용과 구성 그대로 React(Vite)로 옮긴 프로젝트입니다.
원본 바닐라 JS 버전은 `../web-legacy/` 에 백업되어 있습니다.

## 실행 방법

### 1) 빌드해서 Java 서버로 실행 (평소)
```bash
npm install      # 처음 한 번
npm run build    # 결과가 ../web 에 생성됨
```
그다음 이클립스에서 `LocalWebApplication` 을 실행하면 http://127.0.0.1:8787 에서 React 화면이 열립니다.
(Java 코드는 수정하지 않았습니다. `web/` 폴더를 그대로 서빙합니다.)

### 2) 개발 모드 (코드 수정하면서 바로 확인)
1. 이클립스에서 `LocalWebApplication` 실행 (API 서버, 8787)
2. `npm run dev` → http://localhost:5173 접속
   - `/api/*` 요청은 vite.config.js 의 proxy 설정으로 8787 Java 서버에 전달됩니다.

> `web/` 은 빌드 결과물이라 직접 수정하지 말고 `src/` 를 고친 뒤 다시 빌드하세요.

## 구조
```
src/
  main.jsx              React 시작점 (styles.css 불러옴)
  App.jsx               전체 상태 + API 호출 (원본 app.js 의 load* / showPage 등)
  api.js                fetch 래퍼 (api, requestOptions)
  constants.js          상태 코드 필터, 페이지 제목, 아이콘 등 상수
  styles.css            원본 styles.css 그대로
  components/
    Toast.jsx
    auth/               로그인 화면 (로그인·회원가입·아이디 찾기·비밀번호 변경)
    app/                로그인 후 레이아웃 (AppView, Sidebar)
    pages/              메인·물품 관리·물품 대여·반납 및 대여 내역·회원 정보
    modals/             물품 등록/수정, 대여 신청 <dialog>
```
