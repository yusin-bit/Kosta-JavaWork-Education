package ex0814.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapExam {
	Map<String, Integer> map = new TreeMap<String, Integer>();
	
	public MapExam() {
		
		map.put("B", 10);
		map.put("A", 20);
		map.put("C", 40);
		map.put("D", 60);
		map.put("E", 40);
	
		System.out.println("저장된 개수=" +map.size());
		System.out.println("map =" +map);
		
		System.out.println("--key와 value 분리--");
		
		// 먼저 키의 정보들을 추출해야함
		Set<String> Keys = map.keySet();
		Iterator<String> it = Keys.iterator();
		while(it.hasNext()) {
			String Key = it.next();
			Integer value = map.get(Key);
			System.out.println(Key+ "=" +value);
		}
		System.out.println("--개선된 for문--");
		for(String key :map.keySet()) {
			Integer value = map.get(key);
			System.out.println(key+"="+ value);
			
			}
		
		System.out.println("---Entry 형태로 조회하기---");
	 Set<Map.Entry<String, Integer>> set =map.entrySet();
	 
	 for(Map.Entry<String, Integer> e:set) {
		String key = e.getKey();
		Integer i = e.getValue();
		System.out.println(key+"===>" + i);
	 }
		
	 
	 //삭제 
	 
	 Integer re = map.remove("EEE");
	 System.out.println("re="+ re);
	 
	 System.out.println("---삭제 후 결과 값---");
	 System.out.println("map="+ map);
	}
	
	public static void main(String[] args) {
		new MapExam();
	}
}
