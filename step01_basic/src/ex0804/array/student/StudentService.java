package ex0804.array.student;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	
	private Student stArr [] = new Student [5];
	
	// 배열방에서 저장된 객체의 개수를 저장하는 변수
	int count; //0
	
	/**
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
	public void init(String [][] data) {
	
		
	}
	
	/**
	 *  Student객체를 생성해서 리턴해주는 메소드 작성
	 * */
	 
	
	

	 /**
	   학생의 정보 등록하기 
	    : 배열의 경계를 벗어나면 더이상 추가할수 없습니다. 메시지출력.
	      추가가 성공하면 "등록되었습니다" 메시지를 출력
	  **/
	 
	 
	
	/**
	 * 전체 학생의 정보 조회하기
	 * */
	 public void selectAll() {
		 for(int i=0; i< count ; i++) {
			if(stArr[i] !=null)
			 System.out.println(stArr[i]);
			 
		 }
	 }
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를출력하고
	 *     없으면 "찾는정보가 없습니다." 출력한다.
	 * */
	 
	
	
	/**
	 * 이름에 해당하는 학생의 나이와 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할수 없습니다." 출력
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
	 *   "수정되었습니다" 출력
	 *   @param : Student
	 *   @return : void
	 * */
	 

}

