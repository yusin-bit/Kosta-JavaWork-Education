package ex0807.overridingExam;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", explain=");
		builder.append(explain);
		builder.append("]");
		return builder.toString();
	}
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	//@Override
	//public String toString() {
		// TODO Auto-generated method stub
		//StringBuilder
		//return code+":" + name+":" +price+":"+explain;
		
		
	}
