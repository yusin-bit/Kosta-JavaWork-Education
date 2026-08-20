package ex0807.inheritance;
class CarCenter{
	public void engineer(Car cd){
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSsnata ef=new EfSsnata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		
		System.out.println("ef.i =" +ef.i);
		Car c= new Car();
		
		cc.engineer(c);
		cc.engineer(ef);
		cc.engineer(ca);
		cc.engineer(ex);
		
		
	
	}
}
