package ex0729pratice;
import java.util.Scanner;
public class ScannerWhilePractice {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int balance = 0;
		while(true) {
		System.out.println("------------------------------------------------\n"
				                     +"1. 예금  | 2. 출금 |  3. 잔고 | 4. 종료    \n"
				                     +"-------------------------------------------------");
		System.out.print("선택");
		int menu = sc.nextInt();
        		if (menu==1) {
        			System.out.print("예금액을 입력하세요:");
        			int money=sc.nextInt();
        			System.out.println("예금액:"+money);
        			balance=money+balance;
        		} else if (menu==2) {
            			System.out.print("출금액을 입력하세요:");
            			int withdraw=sc.nextInt();   			
            			  if(balance>=withdraw) 
            			  { balance=balance-withdraw;
            			   System.out.println("출금액:"+withdraw);
            	          }else {
            				  System.out.println("잔액이 없습니다");            				  
            	}} else if (menu==3) {
        			System.out.println("잔액:"+balance);
        		} else if (menu==4) {
        			System.out.print("이용해 주셔서 감사합니다"); break;
        		} else {
            			System.out.println("1~에서 4번을 선택해서 입력해 주세요");  		
        		}
	}
 }
}
