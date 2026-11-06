package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("1. 기존방식 -----");
		
		/*Member member = new Member("jang","1234",20,"서울");
		MemberDAO dao = new MemberDAO();	
	    MemberService serivce = new MemberService(dao, member);
	    serivce.selectInsert();*/
		
		 System.out.println("---Spring IoC  Container 사용하기 ---");
		 ApplicationContext application = 
				 new ClassPathXmlApplicationContext("sample02/springDI_Constructor.xml");
		 
		 System.out.println("----------------------");
		 
		 MemberService service =
		   application.getBean("service", MemberService.class);
		 
		 service.selectInsert();

	}

}










