package ex0813.list;

import java.util.ArrayList;
import java.util.List;

public class ListExam03 extends ArrayList<Emp> {
	  public ListExam03() {
	    	//사원 저장
	    	super.add(new Emp(20, "희정", 20, "서울"));
	    	super.add(new Emp(10, "나영", 25, "대구"));
	    	super.add(new Emp(40, "미미", 22, "대전"));
	    	super.add(new Emp(50, "삼순", 28, "서울"));
	    	super.add(new Emp(30, "순돌", 26, "부산"));
	    	
	    }
	    
	    /**
	     * 저장된 모든 사원의 정보 검색
	     * */

		public List<Emp> selectAll() {
			// TODO Auto-generated method stub
			return this;
		}
	    
		/**
	     * 사원의 사원번호에 해당하는 사원정보 검색
	     * @return : 있으면 Emp객체, 없으면 null
	     * */
		public Emp selectByEmpno(int empno) {

		    for(Emp emp : this) {

		        if(emp.getEmpno() == empno) {
		            return emp;
		        }
		    }

		    return null;
		}


	    /**
	     * 주소를 인수로 전달받아 동일한 주소에 해당하는 사원정보 검색
	     * */
	    public List<Emp> selectByAddr(String addr){
	    	List<Emp> findList = new ArrayList<Emp>();
	    	
	    	for(Emp e : this) {
	    		if(e.getAddr().equals(addr)) {
	    			//있다
	    			findList.add(e);
	    		}
	    	}
	    	return findList;
	    }

	    /**
	     * 사원번호를 기준으로 사원정보 정렬하기
	     * */
	    public void sortByEmpno(){
	    	super.sort(null);
	    	
	    }

	    /**
	     * 나이를 기준으로 사원정보 정렬하기
	     * */
	    
	  
	    
		public static void main(String[] args) {
			ListExam03 ex = new ListExam03();
			ex.sortByEmpno();
			List<Emp> list = ex.selectAll();
			for(Emp e: list) {
				System.out.println(e);
				
			}
			
			System.out.println("사원번호에 맞는 사원정보");
			Emp e = ex.selectByEmpno(10);
			System.out.println(e);
			
			System.out.println("주소에 해당하는 사원정보 검색");
			List<Emp> FindList = ex.selectByAddr("부산");
			System.out.println(FindList);
		}
		

	}





