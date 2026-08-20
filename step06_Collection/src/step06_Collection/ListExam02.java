	package step06_Collection;

	import java.util.ArrayList;
	import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


	public class ListExam02{
		
		//List<Integer> list = new ArrayList<Integer>(5);
		List<Integer> list = new LinkedList<Integer>();
		
		public ListExam02() {
			
			// 데이터를 추가
			list.add(5);
			list.add(10);
			list.add(3);
			list.add(7);
			list.add(1);
			list.add(2);
			list.add(8);
			list.add(9);
			
			// 몇개 저장했는지 알고 싶음 
			System.out.println("저장된 객체의 개수 = " + list.size());
			
			//요소 꺼내기 
			for(int i = 0; i<list.size(); i++) {
				int value = list.get(i);
				System.out.println(value);
				
			}
			
			System.out.println("--개선된 for--");
			//개선된 for
			for(int i : list) {
				System.out.println(i);
				
			}
			
			System.out.println("this =" + list);
			
			// 제거
			list.remove(2);
			System.out.println("후 this ="+ list);
			
			//정렬
			Collections.sort(list);//올림차순
			System.out.println("정렬 후 this ="+ list);
			
			//내림차순                               |여기서 순서를 뒤바꿈
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("정렬 후 this = "+ list);
		}

		
		
		public static void main(String[] args) {
			new ListExam02();
		}

	}


