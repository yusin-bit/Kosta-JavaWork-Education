package ex0812;

 class  ShoppingMallAccessException extends Exception {
	 
	 public ShoppingMallAccessException(String message) {
	        super(message);
	    }
 }

 class ShoppingMall { 
	 
	 public void checkAge(int age) throws ShoppingMallAccessException {
		 if(age<18) {
			 throw new ShoppingMallAccessException("애들은 나가라");
		 } else { System.out.println("입장하신 걸 축하합니다");
		 }
	 }
 }


public class ThrowsThrowExam {

	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 10)+10;
		
		
		ShoppingMall mall = new ShoppingMall();
		try {
	        mall.checkAge(num);
	    } catch (ShoppingMallAccessException e) {
	        System.out.println(e.getMessage());
	    }
		

		// TODO Auto-generated method stub

	}

}
