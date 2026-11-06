package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainApp {
	public static void main(String[] args) {
		//기존방식
		/*OrderMessage om =  new OrderMessageImpl();
		OrderMessageImpl omImpl = (OrderMessageImpl)om;
		
		omImpl.setOrderId(100); //<property 
		omImpl.setMessage("되니?");
		omImpl.setProudctBean(new ProductBean());
		omImpl.setUserBean(new UserBean());
		
		
		 om.getOrderMessage();*/
		
		 /////////////////////////////////////////////////////////////////////////
		
		// Spring(IoC) Container -> 객체(springBean) 싱글톤으로 생성해서 메모리 로딩
		ApplicationContext context =
				new ClassPathXmlApplicationContext("sample05/applicationContext.xml");
		   
		
		System.out.println("---------------------------------");
		OrderMessage order = context.getBean("order", OrderMessage.class);
	    order.getOrderMessage();	
 
	
		
	}
	
	
	

}
