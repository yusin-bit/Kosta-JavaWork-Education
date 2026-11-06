package sample10;

import org.springframework.stereotype.Repository;

/*
 * @Repository : DB 접근 클래스(DAO)를 Bean 으로 등록, 기본 id = boardMyBatisDAOImpl
 */
@Repository
public class BoardMyBatisDAOImpl implements BoardDAO {

	public BoardMyBatisDAOImpl() {
		System.out.println("BoardMyBatisDAOImpl 기본 생성자 호출 됨");
	}

	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl : MyBatis 로 게시글 조회");
	}

}
