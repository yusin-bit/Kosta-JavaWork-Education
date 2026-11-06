package sample10;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Lombok 적용 : 아래 어노테이션이 컴파일 시점에 코드를 자동으로 만들어 준다.
 *   @Getter / @Setter    -> getNo(), setNo(int) ... 모든 필드의 getter, setter
 *   @ToString            -> toString()
 *   @NoArgsConstructor   -> BoardDTO()
 *   @AllArgsConstructor  -> BoardDTO(int, String, String)
 *   @Builder             -> BoardDTO.builder().no(1).subject("..").content("..").build()
 *                           (빌더 패턴, 어떤 값이 어떤 필드에 들어가는지 읽기 쉽다)
 *
 * @Component : id 를 생략하면 클래스 이름의 camelCase(boardDTO)가 id
 * 같은 타입(BoardDTO)의 Bean 이 하나 더 있다 -> springDI_annotation.xml 의 id="boardDTO2"
 */
@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
	// 기본 생성자로 만들어지는 Bean(boardDTO)의 기본값
	// @Builder 를 쓰면 필드 초기값이 무시되므로 @Builder.Default 로 기본값을 유지한다.
	@Builder.Default
	private int no = 1;
	@Builder.Default
	private String subject = "@Component 로 등록한 Bean";
	@Builder.Default
	private String content = "기본 생성자로 만들어졌어요";

}
