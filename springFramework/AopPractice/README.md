# AopPractice — AOP 실습 환경

자료: https://drive.google.com/drive/folders/18M9dGo4exZqPXi_0TPNtaDAgo0JGTPhr
원본 이미지 3장은 docs 폴더에 있습니다.

## 설정
- 기존 수업 환경과 동일한 Java 11 / Spring Framework 5.3.39
- spring-context, spring-aop, AspectJ Weaver 1.9.22.1
- Lombok 1.18.34 (provided): getter/setter, 생성자 등 필요할 때 사용
- UTF-8, Maven, STS JavaSE-11
- 일반 Spring Framework 콘솔 과제이므로 Spring Boot나 Tomcat은 필요하지 않습니다.

## 시작
1. src/main/java/kosta/test/MainApp.java → Run As → Java Application.
2. Spring 컨텍스트와 Player 빈 3개가 준비되었다는 메시지를 확인합니다.
3. docs/AopClassDiagram.png와 결과 이미지를 보며 TODO를 작성합니다.

Player, AudioImpl, TvImpl, VedioImpl, LogAdvice, MainApp 틀을 준비했습니다.
다이어그램 표기인 vedio/VedioImpl/volumn을 그대로 유지했습니다.
start/pause/stop 본문, 플레이어 호출, 파일 로그와 Advice 연결은 실습 TODO입니다.
springAOP.xml은 component-scan과 annotation 기반 AOP를 활성화합니다.
LogAdvice는 아직 Aspect/빈으로 등록하지 않았습니다. 구현하면서 연결하세요.

## 환경 확인
src/test/java/setup/EnvironmentCheck.java → Run As → Java Application.
Lombok이 생성한 메서드, Spring XML/빈 생성, 독립 예제의 실제 AOP 가로채기를 확인합니다.
이 파일은 과제의 로그/플레이어 구현과 독립된 환경 확인 코드입니다.
Maven package만으로 이 main 메서드가 자동 실행되지는 않습니다.

Lombok은 STS.ini의 javaagent에 이미 등록되어 있습니다.
새 getter/setter 호출에 STS 오류가 없다면 IDE 연동도 정상입니다.