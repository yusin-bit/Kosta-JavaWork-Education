package ex0806.enumex;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Grade g = Grade.BASIC;
			switch(g) {
			case BASIC :
				System.out.println("일반 고객");
			case SILVER :
				System.out.println("우수 고객");
			case GOLD :
				System.out.println("최우수 고객");
			}
	}

}
