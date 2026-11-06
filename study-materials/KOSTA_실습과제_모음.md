# KOSTA 312기 Java 학습 현황 + 직접 만들어보는 과제

근거 자료
- 노션 「🌈 Java Programming」 본문 31개 + 하위 페이지 12개 + 문제 페이지 9개 (03_Array의 동기화 블록 1개는 읽히지 않음)
- 이클립스 워크스페이스 프로젝트 38개의 소스 (읽기만 했고 컴파일·실행·DB 접속은 하지 않음)

정답 코드는 넣지 않았습니다. 막히면 "힌트 줘"라고 하면 단계별로 알려줍니다.

---

## 1. 내 코드로 본 학습 현황

| 주제 | 노션 | 워크스페이스에서 직접 쓴 코드 | 상태 |
|---|---|---|---|
| 기본 문법·제어문·형변환 | O | step01_basic `ex0729~0730` | 충분 |
| 배열(1·2차원) | O | step01 `ex0803~0804` | 충분 (가변 2차원 배열 코드는 찾지 못함) |
| 메서드·static·오버로딩 | O | step01 `ex0731~0803` (가변인자, printf 포함) | 충분 |
| 생성자·this·싱글톤 | O | step01 `ex0805~0806` | 충분 |
| enum | O | step01 `Grade`, `InsertResult2` | 충분 |
| 상속·오버라이딩·super·다형성 | O | step02 | 충분 |
| 추상클래스·final·인터페이스 | O | step02 `abstract_final`, step03 | 충분 (default/static/private 메서드까지 있음) |
| 예외 | O + 문제 | step04_Exception, WS_07 | 충분 (체크 예외 위주, finally·multi-catch 있음) |
| 제네릭·와일드카드 | O + 문제 | step04_Generic `exam01~05` | 충분 |
| 컬렉션(List/Set/Map)·정렬 | O + 문제 | step06_Collection, WS_04~07 | 충분 |
| 람다·함수형 인터페이스 | O | step05_Lamda | 충분 |
| 메서드 참조·생성자 참조 | O | step16 `lamda/` | 충분 |
| Stream API | (노션 본문 없음) | step16 `stream/` + 연습 10문제 | 충분 |
| IO·직렬화·transient | O + 문제 | step11, step12, step13 | 충분 |
| MVC 구조 | O (웹 기술 흐름) | step06~13, 미니프로젝트 | 충분 |
| 쓰레드·wait/notify | O + 문제 | step14_Thread | 충분 |
| 네트워크·채팅 | O + 문제 | step15_network (1:1, 다중, 닉네임 중복) | 충분 |
| JDBC·PreparedStatement | O + 문제 | step17~21 | 충분 |
| 트랜잭션·Batch·generated keys | O | step17 `TransactionDAO`, step21 `OrderDAOImpl` | 충분 |
| 세션 구현 | - | step21 `SessionSet`, 미니프로젝트 `Session` | 있음 |
| **record / sealed / 패턴 매칭** | O | **코드 없음** | **빈 곳** |
| **Reflection** | O | **코드 없음** | **빈 곳** |
| **var / 텍스트 블록 / List.of** | O | 텍스트 블록은 미니프로젝트에서만, `var` 없음 | 거의 빈 곳 |
| **ExecutorService / 쓰레드풀** | (노션 없음) | 없음 (웹 서버가 풀 8개를 쓰는 곳만 있음) | 빈 곳 |
| 비어 있는 과제 | - | `HM01`, `profileMVC`, `Hello_Java`는 뼈대/빈 클래스 | 미완성 |

참고
- `HW_Sol_01/02`에는 다른 조원·수강생(서인석, 이금배, 남경은, 박범수, 임재열 등) 폴더도 섞여 있습니다. 본인 것은 `유정현` 폴더 등입니다.
- 미니프로젝트(`kostaJavaMiniProject`)는 패키지 선언이 `main.java.com.rental...` 이고 파일은 `src/main/java/com/rental/...` 에 있습니다. 서로 다른 구조라서 Eclipse에서 경고가 나거나 Maven/Gradle로 옮길 때 문제가 될 수 있습니다.
- `practice/ex0812/Program.java`와 미니프로젝트 코드는 수업 예제보다 문법이 현대적입니다(텍스트 블록, switch 식, 중첩 private 클래스). 이 코드를 직접 설명할 수 있는지 확인해 보세요.

---

## 2. 내 코드에서 찾은 개선 과제 (실제 코드 기준)

아래는 이미 있는 코드를 고쳐 보는 과제입니다. 먼저 원인을 설명해 보고 고쳐 보세요.

### 과제 A. 트랜잭션 버그 찾기 – step21_GoodsOrderJDBC `OrderDAOImpl.orderInsert`
- 문제 상황: `finally` 블록에 `con.commit()` 이 있습니다. 주문 상세나 재고 감소 도중 예외가 나면 어떤 일이 생기는지 시나리오를 써보세요.
- 과제: `catch`에서 `rollback`, `finally`에서는 `close`만 하도록 고치고, 재고 부족 상황에서 주문/상세/재고가 모두 되돌아가는지 SELECT로 확인하세요.
- 관련 노션: JDBC, JDBC Batch 처리, 일관성 vs 무결성

### 과제 B. DB 접속 정보 분리 – step17~21, `DBProperties`
- 문제 상황: 일부 파일에 접속 정보(계정·비밀번호·서버 주소)가 소스에 직접 들어 있고, 주석 처리된 클라우드 접속 정보도 있습니다. 저장소(Git)에 올라갔다면 이미 노출된 것으로 봐야 합니다.
- 과제: 접속 정보를 properties로 옮기고(`.gitignore` 등록), 예시 파일 `dbmanager.properties.example`만 커밋하는 구조로 바꾸세요. 이미 올라간 계정이 있다면 비밀번호를 바꾸는 것이 우선입니다.
- 관련 노션: ResourceBundle, step11 파일 경로 주의사항(resources는 읽기 전용 공간)

### 과제 C. 싱글톤이 아닌 싱글톤 – 미니프로젝트 `RentalServiceImpl.getInstance()`
- 문제 상황: `getInstance()`가 호출될 때마다 `new RentalServiceImpl()`을 반환합니다. 같은 클래스의 `Session`은 제대로 된 싱글톤입니다. 차이를 설명해 보세요.
- 과제: 올바른 싱글톤으로 고치고, 같은 객체인지 `==`로 검증하세요.
- 관련 노션: 09_Constructor(싱글톤)

### 과제 D. 여러 사용자가 동시에 접속하면? – 미니프로젝트 `Session` + `LocalWebApplication`
- 문제 상황: `Session`은 로그인 사용자를 하나만 저장합니다. 그런데 웹 서버는 쓰레드 8개로 요청을 처리합니다. 두 브라우저가 동시에 로그인하면 무슨 일이 생길까요?
- 과제: step21의 `SessionSet`처럼 사용자별 세션 구조(키=세션 id)로 바꿔 보는 설계안을 먼저 써보세요. 구현은 그다음입니다.
- 관련 노션: Thread, 동기화, 일관성 vs 무결성

### 과제 E. 삼켜지는 예외 – 미니프로젝트 `DBManager`
- 문제 상황: 초기화와 `close`에서 예외를 잡고 아무것도 하지 않습니다(주석 처리됨). 설정 파일이 없거나 접속이 안 되면 어디서 실패하는지 알기 어렵습니다.
- 과제: 어떤 예외를 어디에서 어떻게 알려야 하는지 정리하고(로그, 사용자 메시지, 재던지기) 고쳐 보세요.
- 관련 노션: Exception 문제

### 과제 F. 비밀번호 평문 저장 – 미니프로젝트 `User` 테이블
- 문제 상황: `PassWord VARCHAR(20)` 컬럼에 평문이 들어갈 구조입니다. 길이 20으로는 해시도 저장할 수 없습니다.
- 과제: 해시 저장이 왜 필요한지 설명하고, 컬럼 길이·로그인 비교 방식이 어떻게 바뀌어야 하는지 설계안을 쓰세요. (구현은 선택)

### 과제 G. 비어 있는 과제 마무리 – `HM01`, `profileMVC`
- 상태: DTO·Service·View 빈 클래스만 있습니다.
- 과제: step13_WeightManager를 **보지 않고** 기능 목록(등록/검색/몸무게 변경/비밀번호 변경)만 보고 직접 완성해 보세요. 막힌 부분만 step13에서 확인합니다.

### 과제 H. 채팅 서버 종료 처리 – step15_network
- 상태: 다중 채팅 서버(`multiChat`, `nickCheck`)는 `readLine()`이 `null`이면 break 하도록 되어 있지만, 1:1 채팅(`ServerChatExam`, `ClientChatExam`)은 `readData.equals("exit")`를 바로 호출하고, 다중 채팅 클라이언트는 `null` 체크 없이 `data + "\n"`을 계속 붙입니다.
- 과제: 상대가 창을 닫거나 먼저 종료되면 각각 어떻게 되는지(NPE인지, 빈 `null` 출력 무한 반복인지) 실행해서 확인하고 고치세요.
- 관련 노션: JFrame x 클릭 – Window vs Mac 차이

---

## 3. 비어 있는 주제를 채우는 새 과제

### 과제 1. 도형 면적 계산기 – record + sealed + switch 패턴 매칭
- `sealed interface Shape permits Circle, Rectangle, Triangle`, 각각 `record`
- `switch (shape) { case Circle c -> ...; }` 로 면적 계산, `default` 없이 컴파일되는지 확인
- 하위 타입 하나를 `permits`에서 빼거나 `switch`에서 빼먹으면 컴파일 오류가 나는 것 확인
- 확인: JDK 17 이상 필요(프로젝트 JRE 설정 확인)

### 과제 2. DTO를 record로 – 기존 코드 바꿔 보기
- step06_Collection `Emp`나 step16 `Student`를 `record`로 바꾸고 달라지는 점을 정리
  (getter 이름, `equals/hashCode`, 필드 변경 불가, `Comparable` 구현 여부, `Comparator.comparingInt(Emp::age)`)
- 바꾸면 깨지는 곳(setter 사용)을 찾아 보기

### 과제 3. 미니 DI – Reflection
- properties에 `service=클래스 전체 이름`을 적고, `Class.forName → getDeclaredConstructor().newInstance()`로 구현체를 만들어 인터페이스 변수에 담기
- `getMethod(...).invoke(...)`로 메서드 호출, `private` 필드를 `setAccessible(true)`로 읽고 쓰기
- 확인: 코드를 안 고치고 properties만 바꿔서 구현체가 바뀌는지, 캡슐화가 깨지는 이유

### 과제 4. 문법 체험 – var, List.of, 텍스트 블록
- `var map = new HashMap<String, Student>();`, `List.of(...)` 불변 리스트에 `add` 하면 나는 예외, 텍스트 블록으로 여러 줄 SQL
- JShell로 컴파일 없이 실행

### 과제 5. 쓰레드풀 – ExecutorService
- step14의 `NumberThread`/`AlphaThread`를 `ExecutorService`(고정 풀)로 바꿔 실행하고, 풀을 닫지 않으면 프로그램이 안 끝나는 것 확인
- `Callable`+`Future`로 1~100 합계를 쓰레드에서 계산해 메인이 결과를 받기

### 과제 6. Stream으로 다시 쓰기 – 기존 코드 리팩터링
- step06 `ListExam03`의 `selectByAddr`, `sortByAge`를 Stream으로 바꾸기
- step13/step12의 정렬을 `Comparator.comparingInt(...).thenComparing(...)`으로 바꾸기

---

## 4. 직접 만들어보기 (기존 수업 흐름 기준)

| # | 만들 것 | 쓰는 개념 | 참고 프로젝트 |
|---|---|---|---|
| 7 | 타입 함정 퀴즈 – `byte c = a + b` 오류, `5 + 'A'`, `5 % 0.0` 결과를 예측하고 실행 | 형변환, 연산 규칙 | step01 `casting` |
| 8 | 반복문 모음집 – 중첩 for·while·do-while으로 구구단 3가지 | 제어문 | step01 `제어문` |
| 9 | 성적표 – switch 3세대 문법(`->`, `yield`)으로 점수→등급 | switch | step01 `SwitchExam02` |
| 10 | 가변 2차원 배열 – 행마다 열 길이가 다른 배열의 합계/평균 | 배열 | 03_Array |
| 11 | 입력 방식 비교 – Scanner와 BufferedReader로 10만 줄 읽고 `nanoTime`으로 비교 | Scanner vs IO, nanoTime | step11 `ScannerVsIOExam` |
| 12 | 메모리 관찰 – 재귀로 `StackOverflowError`, 호출 로그로 LIFO 확인 | 자바 메모리 구조 | 노션 메모리 구조 |
| 13 | 동물 병원 – `Animal` 상속 3종, `instanceof` 패턴(`an instanceof Cat c`) | 상속, 다형성 | step02 |
| 14 | 쇼핑몰 상품 – 생성자 3종 `this(...)`, 싱글톤 서비스 | 생성자, 싱글톤 | step01 `goods` |
| 15 | 등급 enum – 필드+메서드, `valueOf`, `switch` | enum | step01 `Grade` |
| 16 | 은행 계좌 – 사용자 정의 예외 2종, 서비스에서 던지고 뷰에서 처리 | 예외 | WS_07 |
| 17 | 제네릭 저장소 – `Box<T>`, `Pair<K,V>`, `<? extends>`, `<? super>` | 제네릭 | step04_Generic |
| 18 | 회원 명단 – `equals/hashCode`로 중복 가입 방지, `Comparable`+`Comparator` 정렬 | 컬렉션 | step06 |
| 19 | 파일 복사기 – 1바이트/배열/Buffered 3종 속도 비교 | IO | step11 |
| 20 | 객체 저장 주소록 – `Serializable`, `transient`, `serialVersionUID` 바꿔서 `InvalidClassException` 확인 | 직렬화 | step11 `Member` |
| 21 | 쓰레드 3가지 생성 + `join/interrupt/daemon` | Thread | step14 |
| 22 | 생산자-소비자 – `wait/notifyAll`, `while`로 조건 재확인(문제 10번) | 동기화 | step14 `SynchronizedExam` |
| 23 | 다중 채팅 – 닉네임 중복, 퇴장 처리, 클라이언트 `null` 처리 | 네트워크+쓰레드 | step15 |
| 24 | 게시판+댓글 – DAO/Service/Controller/View, 글 삭제 시 댓글도 삭제(트랜잭션) | JDBC | step20 |
| 25 | 주문 시스템 – 로그인(세션)→장바구니→주문(재고 감소) | JDBC+트랜잭션+Batch | step21 |
| 26 | SQL Injection 체험 – `Statement` 우회와 `PreparedStatement` 방어 (본인 로컬 DB에서만) | JDBC 보안 | step17 `SqlInjectionTest` |
| 27 | 대량 등록 – 1000건을 한 건씩/Batch/500건 단위 Batch로 비교 | JDBC Batch | 노션 JDBC Batch |
| 28 | 우산 대여 미니 버전 – user/item/rental, 상태 enum, 승인 시 다른 신청 거절을 한 트랜잭션으로 | 종합 | kostaJavaMiniProject |

DB 실습 주의: 별도 스키마를 만들어서 쓰세요. 미니프로젝트의 `MiniProject_table.sql` 에는 데이터베이스 삭제 구문이 있어 그대로 실행하지 않습니다.

---

## 5. 노션 문제 페이지 복습 (직접 풀고 확인)

답은 적지 않았습니다. 풀어 보고 틀린 번호만 알려 주면 해설합니다.

| 문제 페이지 | 문항 | 핵심 개념 |
|---|---|---|
| Interface | 5 | new 불가, 필드는 `public static final`, 메서드는 `public abstract`, 다중 구현, `default` |
| Exception | 5 | try-catch, `throw` vs `throws`, 사용자 정의 예외 이유 |
| Generic | 5 | 타입 안정성, `<T>`, 컴파일 오류, 제네릭 메서드 선언 위치 |
| List / Comparable / Comparator | 10 | ArrayList vs LinkedList, `add(1, "D")` 결과, `compareTo`, 람다 정렬 |
| Map / Set | 6 | key 중복, `equals/hashCode` 없을 때 HashSet 크기 |
| InputStream / OutputStream | 5 | `read()`의 -1, `write(65)`, `byte[]` 사용 이유 |
| Thread | 10 | `start` vs `run`, `sleep`, `join`, `yield`, `synchronized`, `wait/notify`, `while` |
| Network | 9 | IP/Domain/Port, Private IP, TCP vs UDP, `ServerSocket.accept()` |
| JDBC | 10 | `DriverManager`, `PreparedStatement` 장점, `setString(1, ...)`, `executeQuery/Update`, 닫는 순서 |

---

## 6. 추천 진행 순서

1. 과제 A(트랜잭션 버그) → B(접속 정보 분리): 이미 있는 코드를 읽고 고치는 연습
2. 과제 1·2(record/sealed) → 6(Stream 리팩터링): 빈 곳 채우기
3. 과제 G(HM01/profileMVC 완성) → 22(생산자-소비자) → 23(채팅)
4. 과제 C·D·E(미니프로젝트 설계 개선) → 3(Reflection) → 5(쓰레드풀)
5. 28(우산 대여 미니 버전)로 정리

## 7. 읽지 못했거나 확인하지 못한 것
- 노션 `03_Array`의 동기화 블록 1개, `Web Basic`·`DataBase` 단원(이번 요청 범위 밖)
- 컴파일·실행·DB 연결은 하지 않았습니다. 코드가 실제로 돌아가는지는 확인하지 않았습니다.
- `HW_Sol_01/02`, `WS_*` 중 일부, `step18/19 DBBoard_template`, `step08 mvc_template`, `step14_Network`는 제목과 구조만 보고 세부는 읽지 않았습니다.
