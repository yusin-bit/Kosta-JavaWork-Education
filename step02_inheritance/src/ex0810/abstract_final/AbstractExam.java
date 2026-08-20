package ex0810.abstract_final;

abstract class Animal{
	int legs;
	public abstract void sound();
	public abstract void run();
	public abstract void eat();
	
		// TODO Auto-generated method stub
		
}
  //////////////////////////////////////////////

class Dog extends Animal {
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	@Override
	public void run() {
		System.out.println("잘 뛴다");
	}
	@Override
	public void eat() {
		System.out.println("잘 먹는다");
		// TODO Auto-generated method stub
		
	}
}
///////////////////////////////////////////////
class Cat extends Animal{

	@Override
	public void sound() {
		System.out.println("야옹");
		
	}

	@Override
	public void run() {
		System.out.println("잘 뛰고 잘 올라간다");
		
	}

	@Override
	public void eat() {
		System.out.println("잘 먹는다");
		
	}


	
}
////////////////////////////////////////////////////

class Pig extends Animal{

	@Override
	public void sound() {
		System.out.println("꿀꿀");
		
	}

	@Override
	public void run() {
		System.out.println("못 뛴다");
		
	}

	
public void eat() {
	System.out.println("모든 것을 잘 먹는다");
	
}

}
////////////////////////////////////////////////////////////

public class AbstractExam {
	//매개 변수를 이용한 다형성
	public static void test(Animal animal) {// Cat, Dog, Pig
		//각 동물의 메소드 호출 
		animal.sound();
		animal.eat();
		animal.run();
		System.out.println("--------------------");
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an = null;
		 
		an = new Dog();
		test(an);
		/////////////////////////////////////////////
	    
		an = new Cat();
		test(an);
		/////////////////////////////////////////////
		
		an = new Pig();
		test(an);
	
	}
}
