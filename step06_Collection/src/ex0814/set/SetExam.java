package ex0814.set;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	Set<String> set = new TreeSet<String>(Collections.reverseOrder());
	
	public SetExam(String [] data) {
		for(String s : data) {
			//데이터 추가
			boolean re = set.add(s); //중복 안된다!!
			System.out.println(s + "의 값 add후 결과 =" + re);
		}
		
		System.out.println("최종 결과 = " + set);
		System.out.println("저장된 개수 ="+ set.size());
		
		//요소를 하나씩 꺼내 보자 
		System.out.println("--요소를 하나씩 꺼내보자--");
		
		//Iterator는 자료 구조안에 있는 데이터를 꺼낼 수 있는 메소드를 제공함
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {//hasNext()는 다음요소가 있다면 true 리턴
			String s = it.next();
			System.out.println(s);
		}
		
		/////////////////////////////////////////
		System.out.println("--개선된 for 변경--");
		for(String s : set) {
			System.out.println(s);
		}
		//제거 기능
		System.out.println("---요소 제거하기---");
		boolean re = set.remove("미미2");
		System.out.println("re ="+ re);
		
		System.out.println("제거 후 =" + set);
		
		re = set.contains("희정");
		System.out.println("re ="+ re);
	}
	public static void main(String[] args) {
		
		 String[] data = {"철수", "영희", "민수", "철수", "영희","미미2", "희정"};

		    new SetExam(data);

	}

}
