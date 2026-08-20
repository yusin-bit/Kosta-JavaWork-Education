package ex0803.overloading;
 class Test{
     public void aa(){}
    
     public int aa(int i){
        return 4;
     }
     protected void aa(String s){   }

     String aa(int i, String s){
       return "ddd";
    }
 
  public static void main(String[] args) {
	  	//메소드 호출
	  Test t = new Test();
	  t.aa();
	  t.aa(3);
	  t.aa("하이");
	  t.aa(3,"하이");
	  
	  System.out.println(4);
	  System.out.println("4");
	  System.out.println(4.4);
	  System.out.println(true);

}
 
 
 }
 
 