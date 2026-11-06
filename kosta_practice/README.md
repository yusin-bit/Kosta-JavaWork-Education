# kosta_practice

문제 1~46, 53~57. 일반 자바 프로젝트(JRE 21). 소스는 src, 설정 파일은 resources(클래스패스), 입출력 샘플은 data 에 있습니다.

- 각 문제의 설명(내용/요구사항/사용할 개념)은 아래 파일 맨 위 주석에 있고, 힌트는 맨 아래 주석에 있습니다.
- 패키지로 된 문제는 표의 파일이 진입점(main)이고, 나머지 클래스는 같은 패키지에 있습니다.

| 문제 | 제목 | 파일 | 형태 |
|---|---|---|---|
| 1 | 타입 함정 퀴즈 | src/a_basic/P01_TypeTrap.java | 단일 파일 |
| 2 | 구구단 세 가지 방식 | src/a_basic/P02_MultiplicationTable.java | 단일 파일 |
| 3 | 월의 마지막 날 계산기 | src/a_basic/P03_LastDayOfMonth.java | 단일 파일 |
| 4 | 로또 번호 생성기 | src/a_basic/P04_LottoGenerator.java | 단일 파일 |
| 5 | 가변 길이 2차원 배열 | src/a_basic/P05_JaggedArray.java | 단일 파일 |
| 6 | 배열 예외 두 가지 일부러 내기 | src/a_basic/P06_ArrayExceptions.java | 단일 파일 |
| 7 | 학생 관리(배열 버전) | src/a_basic/p07_student/MainApp.java | 패키지 |
| 8 | 계산기 오버로딩 | src/b_method/P08_CalcOverloading.java | 단일 파일 |
| 9 | 재귀와 스택 메모리 | src/b_method/P09_RecursionStack.java | 단일 파일 |
| 10 | 객체 초기화 순서 관찰 | src/b_method/P10_InitOrder.java | 단일 파일 |
| 11 | 같은 이름 변수 구분하기 | src/b_method/P11_SameNameVariables.java | 단일 파일 |
| 12 | 책 클래스와 생성자 연결 | src/c_oop/P12_Book.java | 단일 파일 |
| 13 | 싱글톤 설정 객체 | src/c_oop/P13_AppConfig.java | 단일 파일 |
| 14 | 로그인 세션 싱글톤 | src/c_oop/p14_session/MainApp.java | 패키지 |
| 15 | 고객 등급 enum | src/c_oop/P15_GradeEnum.java | 단일 파일 |
| 16 | 상태 코드 enum 과 fromCode | src/c_oop/P16_RentalStatusEnum.java | 단일 파일 |
| 17 | 탈것 상속과 생성자 순서 | src/d_inherit/p17_vehicle/MainApp.java | 패키지 |
| 18 | 업캐스팅과 다운캐스팅 | src/d_inherit/p18_casting/MainApp.java | 패키지 |
| 19 | 직원 급여 계산(추상 클래스) | src/d_inherit/p19_employee/MainApp.java | 패키지 |
| 20 | 게시판 인터페이스 3종 | src/d_inherit/p20_board/MainApp.java | 패키지 |
| 21 | 다중 구현과 default 충돌 | src/d_inherit/p21_multi/MainApp.java | 패키지 |
| 22 | final 의 세 얼굴 | src/d_inherit/P22_FinalKeyword.java | 단일 파일 |
| 23 | 쇼핑몰 입장 제한 | src/e_exception/p23_mall/MainApp.java | 패키지 |
| 24 | finally 실험실 | src/e_exception/P24_FinallyLab.java | 단일 파일 |
| 25 | 계좌 출금과 예외 분리 | src/e_exception/p25_account/MainApp.java | 패키지 |
| 26 | 제네릭 타입과 제네릭 메서드 | src/f_collection/p26_generic/MainApp.java | 패키지 |
| 27 | 와일드카드 세 가지 | src/f_collection/p27_wildcard/MainApp.java | 패키지 |
| 28 | 사원 목록 정렬 3종 세트 | src/f_collection/p28_sort/MainApp.java | 패키지 |
| 29 | 중복 회원 막기(HashSet) | src/f_collection/p29_hashset/MainApp.java | 패키지 |
| 30 | 단어 빈도 세기(Map) | src/f_collection/P30_WordCount.java | 단일 파일 |
| 31 | List 구현체 성능 비교 | src/f_collection/P31_ListPerformance.java | 단일 파일 |
| 32 | 함수형 인터페이스 변신 과정 | src/g_lambda/p32_functional/MainApp.java | 패키지 |
| 33 | 메서드 참조 4종 비교 | src/g_lambda/p33_methodref/MainApp.java | 패키지 |
| 34 | 학생 통계(Stream 기본기) | src/g_lambda/p34_stream/MainApp.java | 패키지 |
| 35 | 전공별로 묶기(groupingBy) | src/g_lambda/p35_grouping/MainApp.java | 패키지 |
| 36 | 스트림 결과의 함정 | src/g_lambda/P36_StreamPitfalls.java | 단일 파일 |
| 37 | 파일 복사 속도 비교 | src/h_io/P37_FileCopySpeed.java | 단일 파일 |
| 38 | 줄 번호 붙이기 | src/h_io/P38_LineNumber.java | 단일 파일 |
| 39 | 프로필 저장소(파일 저장) | src/h_io/P39_ProfileStore.java | 단일 파일 |
| 40 | 직렬화 주소록 | src/h_io/p40_serial/MainApp.java | 패키지 |
| 41 | 설정 파일 읽기 세 가지 | src/h_io/P41_ConfigFiles.java | 단일 파일 |
| 42 | 쓰레드 세 가지 생성 방법 | src/i_thread/P42_ThreadCreate.java | 단일 파일 |
| 43 | 쓰레드 멈추기와 데몬 | src/i_thread/P43_InterruptDaemon.java | 단일 파일 |
| 44 | 동시에 증가시키면 생기는 일 | src/i_thread/P44_RaceCondition.java | 단일 파일 |
| 45 | 입금자와 출금자(wait/notify) | src/i_thread/p45_bank/MainApp.java | 패키지 |
| 46 | 다중 채팅 프로그램 | src/i_thread/p46_chat/ServerMain.java | 패키지 |
| 53 | record 로 DTO 만들기 | src/k_modern/P53_Record.java | 단일 파일 |
| 54 | 도형 면적 계산기(sealed + switch) | src/k_modern/p54_shape/MainApp.java | 패키지 |
| 55 | 리플렉션으로 만드는 미니 DI | src/k_modern/p55_reflect/MainApp.java | 패키지 |
| 56 | var · 불변 컬렉션 · 텍스트 블록 | src/k_modern/P56_ModernSyntax.java | 단일 파일 |
| 57 | this() 앞에서 검증하고 싶을 때 | src/k_modern/P57_ConstructorValidation.java | 단일 파일 |
