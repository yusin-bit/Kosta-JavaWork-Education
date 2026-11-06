package sample10;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * BoardDAO 타입의 Bean 이 2개(boardMyBatisDAOImpl, boardOracleDAOImpl)이므로
 * 타입만으로는 어떤 것을 주입할지 알 수 없다.
 */
@Service
public class BoardServiceImpl implements BoardService {

	// @Autowired : 타입이 여러 개이면 필드명과 같은 id 의 Bean 으로 주입(byName)
	@Autowired
	private BoardDAO boardMyBatisDAOImpl;

	// @Qualifier : 주입할 Bean 의 id 를 지정
	@Autowired
	@Qualifier("boardOracleDAOImpl")
	private BoardDAO boardOracleDao;

	// @Resource (JSR-250) : 이름 기반 주입, name 속성으로 Bean id 지정 (javax.annotation-api 필요)
	@Resource(name = "boardOracleDAOImpl")
	private BoardDAO boardResourceDao;

	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl 기본 생성자 호출 됨");
	}

	@Override
	public void select() {
		System.out.println("[@Autowired byName]");
		boardMyBatisDAOImpl.select();

		System.out.println("[@Autowired + @Qualifier]");
		boardOracleDao.select();

		System.out.println("[@Resource(name)]");
		boardResourceDao.select();
	}

}
