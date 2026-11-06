package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//1.기존방식
		/*MessageBean bean = new MessageBeanKoImpl();
		bean.sayHello("희정");
		
	    System.out.println("----------------");
	    bean = new MessageBeanEnImpl();
	    bean.sayHello("heejung");*/
		
		/////////////////////////////////////
		//2. Spring IoC 즉  Spring Container로 bean 관리하기 
		/*
		 *  ApplicationContext는 BeanFactory(객체의 생성, 소멸에 관한 라이프사이클) 를 상속받은
		 *   interface로 BeanFactory기능 + 다국어지원, 메시지처리, 부가적인 기능이 추가되었다
		 *  
		 * 
		 * ApplicationContext Spring Container는 bean들을 singleton으로 관리한다.
		 *  : 사전초기화(미리 객체를 생성해서 메모리위에 올린다.)
		 *  : 동일한 id를 여러번 getBean을 해도 항상 동일한객체(공유)
		 *  
		 *  
		 *  bean생성할때 scope="prototype" 옵션을 설정하면 
		 *  지연초기화로 필요할때마다 새로운객체를 생성해준다.
		 * */
		
		
		
		ApplicationContext application = 
				new ClassPathXmlApplicationContext("sample01/applicationContext.xml");

		
		System.out.println("---bean객체안에 있는 메소드 호출------------");
		MessageBean bean = application.getBean("en", MessageBean.class);
		bean.sayHello("heejung");
		
		bean = application.getBean("ko", MessageBean.class);
		bean.sayHello("희정");
		
		System.out.println("-----------------------");
		MessageBean bean2 = application.getBean("ko", MessageBean.class);
		
		System.out.println("bean = "+ bean);
		System.out.println("bean2 = " + bean2);
		
	}

}






