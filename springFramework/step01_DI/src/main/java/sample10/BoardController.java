package sample10;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// BoardDTO 타입 Bean 이 2개(boardDTO : @Component, boardDTO2 : xml)
	@Resource(name = "boardDTO")
	private BoardDTO boardDTO;

	@Autowired
	@Qualifier("boardDTO2")
	private BoardDTO boardDTO2;

	public BoardController() {
		System.out.println("BoardController 기본 생성자 호출 됨");
	}

	public void test() {
		System.out.println("boardDTO = " + boardDTO);
		System.out.println("boardDTO2 = " + boardDTO2);
		boardService.select();
	}

}
