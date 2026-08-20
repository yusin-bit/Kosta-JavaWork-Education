package ex0812;

public class Presentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int price = 120000;
		double discount = 0;

		if (price >= 50000) {
		    discount = 0.05;
		} else if (price >= 100000) {
		    discount = 0.10;
		}

		int finalPrice = (int)(price * (1 - discount));

		System.out.println("결제 금액 : " + finalPrice);
	}

}
