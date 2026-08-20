package ex0810.abstract_final;


//Error 를 수정하고 이유를 주석으로 처리하세요.

 class FinalClassExam{
 final int i = -999999; 
}


abstract class AbstractClassExam{
    abstract String abstractMethodExam1(int i,String s);    
     int finalMethodExam(int i, int j){ 
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	int finalMethodExam(int i, int j){ // final 메소드 재정의 불가
		return i*j;
	}

	@Override
	String abstractMethodExam1(int i, String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Sample02 extends FinalClassExam{  } // final class 상속 불가


 
abstract class Sample03 extends AbstractClassExam{ // abstract메소드가 있을시 그 클래스도 abstract 클래스 
	 String abstractMethodExam1(int i,String s){  
		return s+i;
	 }
	abstract String abstractMethodExam(int i,String s); // abstract메소드가 있을시 그 클래스도 abstract 클래스 

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		AbstractClassExam ace = new Sample01(); 
		FinalClassExam fce = new FinalClassExam();
		//fce.i=100000;
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam1(700,"_999");
	}
}
