package dogprogram;

public class DogStartPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DogService dogservice = new DogService();
		System.out.println("강아지 구매 프로그램을 시작합니다");
		
		Dog[] dogs = { new Dog(101, "초코", 2, 800000, "푸들" ),
				       new Dog(102, "콩이", 1, 700000, "말티즈" ),
				       new Dog(103, "보리", 3, 900000, "푸들" ),
				       new Dog(104, "하루", 2, 800000, "시바견" ),
			    	 };
		dogservice.init(dogs);
		Menu menu = new Menu(dogservice);
		menu.menu();
	}

}
