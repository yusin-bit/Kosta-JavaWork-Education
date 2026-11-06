package sample10;

import org.springframework.stereotype.Repository;

/*
 * 기본 id = boardOracleDAOImpl
 */
@Repository
public class BoardOracleDAOImpl implements BoardDAO {

	public BoardOracleDAOImpl() {
		System.out.println("BoardOracleDAOImpl 기본 생성자 호출 됨");
	}

	@Override
	public void select() {
		System.out.println("BoardOracleDAOImpl : Oracle 로 게시글 조회");
	}

}
