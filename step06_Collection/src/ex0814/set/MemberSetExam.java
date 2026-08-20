package ex0814.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
		
	public MemberSetExam() {
		set.add(new Member("희정", 10, "서울"));
		set.add(new Member("철수", 20, "서울"));
		set.add(new Member("영희", 25, "부산"));
		set.add(new Member("민수", 30, "대전"));
		set.add(new Member("희정", 22, "서울"));
		set.add(new Member("나영", 27, "대구"));
		set.add(new Member("순돌", 24, "인천"));
		set.add(new Member("미미", 21, "광주"));
		set.add(new Member("철수", 20, "서울")); // 중복
		set.add(new Member("희정", 22, "서울")); // 중복
		set.add(new Member("영희", 25, "부산")); // 중복
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
