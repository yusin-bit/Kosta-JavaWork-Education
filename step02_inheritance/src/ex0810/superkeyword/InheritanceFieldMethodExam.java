package ex0810.superkeyword;

class Animal{
	int age = 5;
	String bodyColdr;
	
	public void sound() {
		System.out.println("super의 sound call");
	}
	public void eat() {
		System.out.println("super의 eat call");
 } 
}
/////////////////////////////////////////////////////////////
class Cat extends Animal{
	int age = 10;
	int weight;
	
	public void sound() {
		System.out.println("Cat의 Sound call");
	}	
	public void run() {
			System.out.println("Cat의 run call");
	}	
	public void test() {
			System.out.println(age);
			System.out.println(this.age);
			System.out.println(super.age);
			
			System.out.println("-----------------------------");
			
			System.out.println(weight);
			System.out.println(this.weight);
			
			System.out.println("=======메소드 호출=======");
			
			sound();
			this.sound();
			super.sound();
			
			System.out.println("-----------------------------");
			
			
	}
}
public class InheritanceFieldMethodExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		cat.test();
		//////////////////////////////////////////////////
		Cat dogs = new Cat();
		System.out.println("--외부에서 객체 생성 접근--");
		System.out.println(cat.age);
		System.out.println(cat.weight);
		
		
		System.out.println("------------다형성---------------");
		Animal an = new Cat();
		System.out.println(an.age);
	
		
	}

}
