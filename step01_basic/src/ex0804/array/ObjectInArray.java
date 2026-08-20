//ObjectInArray.java
package ex0804.array;

class Student{
	private String name;
	private int age;
//	String name;
//	int age;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		if(age>18) {
			this.age=age;
			System.out.println("입력이 완료되었습니다.");
		}
		else System.out.println("나이 제대로~~");
	}
	public int getAge() {
		return this.age;
	}
}
class qwe{
	public void studentExample() {
		Student st = new Student();
		// st.name="11"; // private라서 직접 접근할 수 없다.
		st.setName("홍길동");
		System.out.println(st.getName());
	}
}

class ObjectOne{
	public int a;
}

public class ObjectInArray{
	// main 메소드에서
		public static void main(String[] args) {
			ObjectOne [] arr = new ObjectOne[5];  // ObjectOne 타입을 5개 저장할 수 있는 배열을 선언하고
			
			for(int k = 0 ; k < arr.length ; k++) {
			arr[k] = new  ObjectOne();
			 arr[k].a = (k + 1) * 10;
		}
			 for (int i = 0; i < arr.length; i++) {
		            System.out.println("객체 주소값 : " + arr[i]);
		            System.out.println("객체의 a 값 : " + arr[i].a);
	

	// 5개의 ObjectOne 객체를 생성하세요.
	// 각 객체가 저장되어 있는 배열의 값 출력
	// 각 객체의 주소값 출력

	// 생성된 ObjectOne 객체에 서로 다른 a의 값을 저장한 후
	// a의 값을 출력하세요.
	// 각 ObjectOne 객체의 a를 출력하세요.
			
		
			 }
		}
}
