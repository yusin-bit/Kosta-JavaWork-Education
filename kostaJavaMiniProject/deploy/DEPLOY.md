# 빌림 무료 배포 가이드

| 구성 | 서비스 | 주소 |
|---|---|---|
| 화면 (React) | GitHub Pages — `yusin-bit.github.io` 저장소의 `billim/` | https://yusin-bit.github.io/billim/ |
| API 서버 (Java) | Render 무료 Web Service — 같은 저장소의 `billim-server/` (Docker, `render.yaml` Blueprint) | https://billim-rental.onrender.com |
| DB (MySQL) | Aiven 무료 MySQL | Aiven 이 발급 |

> 무료 플랜 특성: Render 는 15분 동안 요청이 없으면 잠들고, 다음 첫 요청 때 깨어나는 데 1분 정도 걸립니다.
> Aiven 무료 MySQL 은 오래 쓰지 않으면 꺼질 수 있습니다(메일 안내 후 콘솔에서 다시 켜기).

---

## 1. Aiven — MySQL 만들기 (직접)
1. https://aiven.io 가입 (카드 불필요)
2. **Create service → MySQL → Free plan** → Create
3. Running 이 되면 **Overview → Connection information** 확인 (Host, Port, User, Password, Database)

## 2. DB 초기화
1. `deploy/aiven.properties` 에 접속 정보 입력 (이 파일은 git 에 올라가지 않음)
   ```
   url=jdbc:mysql://<Host>:<Port>/defaultdb?sslMode=REQUIRED
   userName=avnadmin
   userPass=<Aiven 비밀번호>
   ```
2. 프로젝트 폴더에서 실행
   ```bash
   java -cp C:/Edu/DB/JDBC/util/mysql-connector-j-8.4.0.jar deploy/tools/CloudInit.java --apply
   ```
   - 빈 DB 에만 `deploy/cloud-init.sql` 을 실행합니다 (이미 테이블이 있으면 건너뜀). DB 를 지우는 문장은 없습니다.
   - 테이블 10개(회원 정지·탈퇴·공지사항·관리자 활동 기록·물품 사진 포함) + 뷰 3개 + 시드 데이터(회원 20, 물품 45, 대여 125). 시드 회원 비밀번호는 해시로 저장되고 기존 비밀번호로 로그인됩니다.
   - 관리자 계정은 이 스크립트에 들어 있지 않습니다. 무작위 비밀번호로 따로 등록합니다 (`deploy/admin-credentials.txt`).
3. **예전(테이블 7개) DB 에 관리자 확장 기능을 추가할 때**
   ```bash
   java -cp C:/Edu/DB/JDBC/util/mysql-connector-j-8.4.0.jar deploy/tools/Migrate.java aiven deploy/migrations/002_admin_features.sql   # 클라우드
   java -cp C:/Edu/DB/JDBC/util/mysql-connector-j-8.4.0.jar deploy/tools/Migrate.java local deploy/migrations/002_admin_features.sql   # 로컬 mini
   ```
   - 이미 적용된 항목은 건너뜁니다. DB 를 지우는 문장은 없습니다.

## 3. Render — Java 서버 만들기 (직접)
1. https://render.com 가입 (**GitHub 로 로그인**)
2. **New + → Blueprint → `yusin-bit/yusin-bit.github.io`** 선택
   - 저장소의 `render.yaml` 이 이름(`billim-rental`), Docker, 무료 플랜, 헬스체크, 빌드 필터, `ALLOWED_ORIGINS` 를 자동으로 채웁니다.
3. 입력 칸 3개만 채우기 (aiven.properties 와 같은 값)
   | Key | Value |
   |---|---|
   | `DB_URL` | `jdbc:mysql://<Host>:<Port>/defaultdb?sslMode=REQUIRED` |
   | `DB_USER` | `avnadmin` |
   | `DB_PASSWORD` | Aiven 비밀번호 |
4. Apply → 빌드 로그 끝에 `빌림 로컬 웹 프로그램 실행: http://0.0.0.0:...` 이 나오면 성공
5. 확인: `https://billim-rental.onrender.com/api/health` → `{"ok":true,"database":"defaultdb"}`
   - 주소가 다르게 나오면 `frontend/.env.pages` 의 `VITE_API_BASE` 를 바꾸고 다시 배포합니다.

## 4. 화면 확인
https://yusin-bit.github.io/billim/ → 로그인 화면의 통계 숫자가 나오면 서버·DB 연결 완료
(서버가 잠들어 있으면 첫 접속 때 숫자가 늦게 뜰 수 있습니다)

---

## 코드 수정 후 다시 배포하기
```bash
bash deploy/publish.sh          # 화면 빌드 + github.io 저장소에 파일 복사
cd ~/Documents/yusin-bit.github.io
git add billim billim-server && git commit -m "빌림 업데이트" && git push
```
- `billim/` 은 push 후 1~2분 안에 GitHub Pages 에 반영됩니다.
- `billim-server/` 가 바뀌면 GitHub Actions 가 Docker 빌드를 확인하고, Render 가 자동으로 다시 배포합니다.
- Render 화면에 **Failed deploy** 가 뜨면 서비스 → Events → 실패한 배포의 로그 맨 아래를 확인합니다. 실패해도 이전 버전이 계속 돌아갑니다.
  - 예전에 Maven Central 이 Render 빌드 서버에 `429`(요청 과다)를 돌려줘 실패한 적이 있어서, MySQL 드라이버는 `deploy/server/lib/` 에 넣어 두고 Dockerfile 이 복사해서 씁니다 (공식 sha256 확인 유지).

## 웹에서 할 수 있는 기능
| 영역 | 회원 | 관리자 (로그인 화면 아래 "관리자 로그인") |
|---|---|---|
| 회원 | 가입·로그인·아이디 찾기·비밀번호 재설정/변경 | 회원 목록, 정보 수정(닉네임·이름·전화번호), **이용 정지/해제**(사유 필수, 정지 즉시 로그아웃, 로그인 시 사유 표시), 임시 비밀번호 발급, 로그인 잠금 해제, 강제 로그아웃, **탈퇴 처리 / 완전 삭제** (아래 표) |
| 물품 | 등록·수정·삭제 | 전체 조회, 이름·카테고리 수정, 삭제(게시글 없는 물품), 대여 상태 복구 |
| 대여 글 | 등록(물품 등록 직후 자동 안내)·수정·삭제, 상세 검색(제목·내용·장소·대여일·물품번호) | 전체 조회, 제목·내용·날짜·장소 수정, 삭제(대여 내역 없는 글) |
| 대여 | 신청 → 승인/거절 → 대여 시작 → 반납 신청 → 반납 승인 → 반납 확인 → 완료 | 상태별 조회, 승인 대기 신청 거절, **진행 중 대여 강제 완료/강제 취소**(물품 상태 자동 복구) |
| 카테고리 | 선택 | 대분류·소분류 추가, 사용하지 않는 분류 삭제 |
| 공지사항 | 로그인 전·후 화면 위쪽에 표시 | 작성·수정·숨김/게시·삭제 |
| 관리자 계정 | — | 관리자 추가(비밀번호 영문+숫자 8자 이상)·삭제(본인 삭제 불가, 최소 1명 유지), 내 비밀번호 변경 |
| 현황 | 메인 화면 요약 | 상태별 건수 + 통계(인기 카테고리, 많이 빌려준/빌린 회원) |
| 활동 기록 | — | 관리자 변경 작업 기록(누가·언제·무엇을·대상·결과, DB 에 저장) |

### 물품 사진
| 단계 | 하는 곳 | 내용 |
|---|---|---|
| 고르기·줄이기 | 화면(브라우저) | 물품 등록·수정 창에서 사진 선택 → 긴 변 1000px JPEG 로 줄여 미리보기 (휴대폰 사진도 수백 KB 로) |
| 검사·저장 | 서버 | 물품 주인만, 512KB 이하, JPEG/PNG 매직 바이트 확인, 6000px·2400만 픽셀 넘으면 거절(압축 폭탄 방지) → JPEG 로 다시 저장해 촬영 위치 등 메타데이터 제거 → DB `ItemImage` |
| 보여주기 | 서버 → 화면 | `GET /api/items/image?itemNum=&v=` (로그인 없이, 7일 캐시, v=수정 시각이라 바꾸면 새로 받음). 사진이 없으면 카테고리 아이콘 |
| 정리 | DB | 물품 삭제·회원 완전 삭제 시 사진도 함께 삭제 (`ON DELETE CASCADE`) |

- 서버 디스크가 아니라 DB 에 저장하는 이유: Render 무료 서버는 재배포·재시작 때 디스크가 초기화됩니다. 사진 45장 ≈ 4MB.
- 관리자: 물품 탭에서 사진 등록·변경·삭제 (부적절한 사진 정리용)
- 예시 물품 45개 사진: Wikimedia Commons 의 자유 이용 사진만 사용, 같은 모델이 없으면 "비슷한 제품"으로 표시 → [`image-credits.md`](image-credits.md), 사이트의 `image-credits.html`
- DB 테이블: `deploy/migrations/004_item_image.sql` (예전 DB 는 Migrate 명령에서 파일 이름만 바꿔 실행)

### 회원 탈퇴 처리 vs 완전 삭제
| | 탈퇴 처리 | 완전 삭제 |
|---|---|---|
| 회원 정보 | 행은 남고 이름·닉네임 "탈퇴회원", 전화번호·비밀번호는 무작위 값 → 로그인·아이디 찾기·재설정·재가입 불가 | 삭제 (같은 아이디로 다시 가입 가능) |
| 물품·대여 글 | 남지만 대여 불가로 바뀌어 목록에서 사라짐 | 삭제 |
| 지난 대여 기록 | 남음. 상대방 내역에는 "탈퇴회원"으로 표시 | 양쪽 모두 삭제 (상대방 내역에서도 사라짐) |
| 승인 대기 신청 | 자동 거절 | 삭제 |
| 진행 중인 대여 | 있으면 실행 안 됨 → 대여 관리에서 먼저 강제 완료/취소 | 같음 |
| 되돌리기 | 불가 (정지 해제·정보 수정·임시 비밀번호도 막힘) | 불가. 회원 아이디를 한 번 더 입력해야 실행 |
| 활동 기록 | `users/withdraw userId=...` | `users/delete userId=... items=N posts=N rentals=N` |

- DB 컬럼 `User.Withdrawn` 이 필요합니다: `deploy/migrations/003_user_withdraw.sql` (예전 DB 는 위 2-3 의 Migrate 명령에서 파일 이름만 바꿔 실행)

### 관리자 계정
- 아이디: `admin01`, `admin02`, `admin03` (관리자 화면의 "관리자" 탭에서 추가·삭제 가능)
- 비밀번호: **`deploy/admin-credentials.txt`** (git 에 올라가지 않음). 공개 저장소의 시드 비밀번호는 더 이상 쓰이지 않습니다.
- 관리자 토큰은 회원 토큰과 따로 관리되어, 회원 토큰으로 관리자 API 를 호출할 수 없습니다.

## 보안 설정 요약
| 항목 | 내용 |
|---|---|
| 로그인 | 사용자별 토큰(메모리), 2시간 미사용·12시간 경과 시 만료, 계정당 동시 5개 |
| 비밀번호 | PBKDF2 해시 저장(예전 평문은 로그인 시 자동 전환), 4~20자 |
| 무작위 대입 | 같은 아이디 로그인 실패 5회 → 15분 잠금 / 재설정 계정당 1시간 3회 / 아이디 찾기 IP당 1시간 10회 |
| 요청 제한 | IP당 전체 300회/분, 인증 API 30회/분, 회원가입 5회/시간, 본문 16KB, 물품 1인 30개 |
| 입력 검증 | 아이디 영문·숫자·_ 4~20자, 전화번호 010-1234-5678 형식 |
| 응답 | 500 오류는 일반 문구만(상세는 서버 로그), 보안 헤더·CSP, JSON 이스케이프 |
| IP 판별 | `TRUSTED_IP_HEADER` 로 지정한 헤더만 신뢰 (Render: `CF-Connecting-IP`) |
| 동시 요청 | 대여 신청·승인은 게시글 행을 잠그고(`SELECT ... FOR UPDATE`) 처리 → 같은 신청 중복·이중 승인 방지 |
| 관리자 감사 로그 | 관리자 변경 요청마다 `[admin-audit]` 서버 로그 + DB `AdminLog` 저장(관리자·IP·경로·대상·결과). 대상은 정해진 항목(아이디·번호·이름·사유 등)만 남기고 **비밀번호는 기록하지 않음** → 관리자 화면 "기록" 탭 |
| 회원 정지 | 정지 즉시 해당 회원의 모든 세션 종료, 로그인 차단 |
| 전송 보안 | HTTPS 강제(http → https), HSTS, 화면은 iframe 삽입 차단(클릭재킹 방지) |

### 남은 한계 (실습용이라 감수)
- 비밀번호 재설정이 **아이디 + 전화번호**만으로 가능합니다. 시드 데이터의 전화번호는 공개돼 있어서, 시도 횟수 제한만으로는 완전히 막을 수 없습니다. 실서비스라면 이메일·문자 인증이 필요합니다.
- 시드 계정(user01~20)의 비밀번호는 공개 저장소의 테스트 데이터와 같습니다.
- 로그인 잠금은 다른 사람이 일부러 틀려서 내 계정을 15분 잠글 수도 있다는 뜻입니다.
- 서버가 1대라 세션·요청 제한은 메모리에만 있고, Render 가 재시작하면 모두 로그아웃됩니다.
- Render ↔ Aiven 구간은 암호화(SSL)되지만 서버 인증서 검증(VERIFY_CA)은 하지 않습니다. 필요하면 Aiven CA 인증서를 이미지에 넣어 강화할 수 있습니다.

## 휴대폰 화면
- 갤럭시(Z Flip·Fold 접힘 344px, S 시리즈 360·412px), 아이폰(375·390·430px), 태블릿(690px), PC(1280px) 에서 가로 넘침 없이 표시됩니다.
- 650px 이하: 아래쪽 메뉴(짧은 이름), 표는 카드 모양(칸마다 머리글 이름표), 노치·홈 바 여백(safe-area)
- 980px 이하: 위쪽에 로그아웃 버튼, 관리자 메뉴는 두 줄 + 선택한 탭으로 자동 스크롤

## 바탕화면 앱
- `빌림 대여 시스템` 바로가기 → `Documents/BillimRentalApp` (로컬 mini DB 사용). `app/classes` 와 `app/web` 을 최신 빌드로 바꾸면 업데이트됩니다. 이전 버전은 같은 폴더의 `backup-*` 에 있습니다.
- 앱은 `app` 폴더를 작업 폴더로 실행해야 합니다 (`resources/dbmanager.properties`, `web` 을 상대 경로로 찾음).

## 로컬 실행 (기존과 동일)
- 이클립스에서 `LocalWebApplication` 실행 → http://127.0.0.1:8787 (로컬 `resources/dbmanager.properties` 사용)
- 환경변수 `DB_URL`, `DB_USER`, `DB_PASSWORD`, `PORT`, `HOST`, `ALLOWED_ORIGINS`, `OPEN_BROWSER` 로 설정을 바꿀 수 있습니다.
