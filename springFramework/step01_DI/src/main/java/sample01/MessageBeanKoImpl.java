package sample01;

public class MessageBeanKoImpl implements MessageBean {
	
	public MessageBeanKoImpl() {
		System.out.println("MessageBeanKoImpl 생성자 호출");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요."+  name);

	}

}
