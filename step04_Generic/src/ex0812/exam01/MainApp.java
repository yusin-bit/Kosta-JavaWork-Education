package ex0812.exam01;

public class MainApp {

	public static void main(String[]args) {
		//제너릭이 없는 경우
/*		Box box = new Box();
		box.setContent("상품1");
		
		if(box.getContent() instanceof String) {
			String content = (String)box.getContent();
			System.out.println(content);
		}
	
		box.getContent(new Board());
		if(box.getContent() instanceof Board) {
			
		  Board content = (Board)box.getContent();
		  System.out.println(content.getBno());
	}*/
	
	System.out.println("**제너릭 사용**");
	Box<String> box = new Box<>();
	box.setContent("안녕");
	
	String content = box.getContent();
	System.out.println("content=" + content);
	/////////////////////////////////////////////////////
	
	}
}
