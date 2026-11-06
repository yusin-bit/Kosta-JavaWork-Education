package sample03;

public class BookVo {
   private String subject;//null
   private String writer;//null
   private int price;//0
   private String date;//null
   
   public BookVo(){}
   
	public BookVo(String subject, String writer, int price, String date) {
		System.out.println("BookVo 인수 4개 생성자..");
		this.subject = subject;
		this.writer = writer;
		this.price = price;
		this.date = date;
	}
	
	public String getSubject() {
		return subject;
	}
	public String getWriter() {
		return writer;
	}
	public int getPrice() {
		return price;
	}
	public String getDate() {
		return date;
	}
	
	
   
   
}
