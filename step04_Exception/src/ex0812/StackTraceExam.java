package ex0812;

	
	public class StackTraceExam {

	    public static void main(String[] args) {
	        login();
	    }

	    static void login() {
	        findUser();
	    }

	    static void findUser() {
	        String name = null;
	        System.out.println(name.length());
	    }
	}

