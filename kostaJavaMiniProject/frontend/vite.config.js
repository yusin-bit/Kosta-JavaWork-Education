import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'

// npm run build       → ../web 에 빌드. Java LocalWebApplication(StaticHandler)이 그대로 서빙 (로컬·바탕화면 앱)
// npm run build:pages → dist-pages 에 빌드. GitHub Pages 의 /billim/ 경로용, API 는 .env.pages 의 Render 주소로 요청
// npm run dev         → /api 요청을 실행 중인 Java 서버(8787)로 넘긴다.

// 빌드 결과 index.html 에 CSP(Content-Security-Policy) 를 넣는다.
// GitHub Pages 는 응답 헤더를 바꿀 수 없어서 <meta> 로 넣고, 개발 서버에서는 인라인 스크립트가 필요해 빌드에만 적용한다.
const contentSecurityPolicy = apiBase => ({
  name: 'billim-csp',
  apply: 'build',
  transformIndexHtml: () => [{
    tag: 'meta',
    attrs: {
      'http-equiv': 'Content-Security-Policy',
      content: [
        "default-src 'self'",
        "script-src 'self'",
        "style-src 'self'",
        `img-src 'self' data: blob:${apiBase ? ` ${apiBase}` : ''}`,
        `connect-src 'self'${apiBase ? ` ${apiBase}` : ''}`,
        "object-src 'none'",
        "base-uri 'self'",
        "form-action 'self'",
      ].join('; '),
    },
    injectTo: 'head-prepend',
  }],
})

export default defineConfig(({ mode }) => {
  const pages = mode === 'pages'
  const env = loadEnv(mode, process.cwd(), 'VITE_')
  return {
    plugins: [react(), contentSecurityPolicy(env.VITE_API_BASE)],
    base: pages ? '/billim/' : '/',
    build: {
      outDir: pages ? 'dist-pages' : '../web',
      emptyOutDir: true,
    },
    server: {
      port: 5173,
      proxy: {
        '/api': 'http://127.0.0.1:8787',
      },
    },
  }
})
