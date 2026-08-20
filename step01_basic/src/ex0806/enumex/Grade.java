package ex0806.enumex;
/**
 *  enum은 열거형으로 안에 정의된 정보는 static final = 상수이다.
 * */
public enum Grade {
		BASIC("우수", 200, 1),
		SILVER("우수", 200, 10),
		GOLD("최우수", 300, 15);
		
	
		private final String kind;
		private final int point;
		private final int role;

		Grade(String kind, int point, int role) {
			this.kind = kind;
			this.point = point;
			this.role = role;
		}

		public String getKind() { return kind; }
		public int getPoint() { return point; }
		public int getRole() { return role; }
}
//////////////////////////////////////////
