package ex0728.연산자;
class BooleanOPeratorExam{
	public static void main(String args[]){
		boolean  t=true ;
		boolean f=false;
		System.out.println("true&false="+(t&f)); // true&false=false
		System.out.println("true&true="+(t&t)); // true&true = true
		System.out.println("false&false="+(f&f)); // false&false = false
		System.out.println();
	
		System.out.println("true|false="+(t|f)); // true|false = true
		System.out.println("true|false="+(t|t)); // true|false = true
		System.out.println("false|false="+(f|f)); // false|false = false
		System.out.println();

		System.out.println("true^false="+(t^f)); // true^false = true
		System.out.println("true^true="+(t^t)); // true^true = false
		System.out.println("true^false="+(t^f)); // true^false = true
		System.out.println("true^true="+(t^t)); // true^true = false 
		System.out.println();

		System.out.println("true&&false="+(t&&f)); // true&&false = false
		System.out.println("true&&true="+(t&&t)); // true&&true = true
		System.out.println("true&&false="+(t&&f)); // true&&true = true
		System.out.println("false&&false="+(f&&f)); // false&&false =false
		System.out.println();

		System.out.println("true||false="+(t||f)); // true||false = true
		System.out.println("true||true="+(t||t)); // true||true = true 
		System.out.println("false||false="+(f||f)); // false||false = false 
		System.out.println();

		int i=5; int j=3;
		System.out.println("int i="+i+"\tint j="+j);
		System.out.println("i>=j==>>"+(i>=j));
		System.out.println("i>j=>>"+(i>j));
		System.out.println("i<=j=>>"+(i<=j));
		System.out.println("i<j=>>"+(i<j));
		System.out.println("i==j=>>"+(i==j));
		System.out.println("i!=j=>>"+(i != j));}
}

	
