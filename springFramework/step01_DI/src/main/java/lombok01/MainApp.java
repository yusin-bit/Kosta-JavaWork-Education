package lombok01;

public class MainApp {

	public static void main(String[] args) {
		// 1) 빌더로 객체 생성 : builder() -> 필드 이름으로 값 지정 -> build()
		User user = User.builder()
				.name("홍길동")
				.age(25)
				.build();

		// 2) @Data 가 만들어 준 getter
		System.out.println(user.getName()); // 홍길동
		System.out.println(user.getAge()); // 25

		// 3) @Data 가 만들어 준 toString()
		System.out.println(user); // User(name=홍길동, age=25)

		// 4) @Data 가 만들어 준 setter (그래서 값이 바뀔 수 있는 가변 객체)
		user.setAge(26);
		System.out.println(user);
	}

}
