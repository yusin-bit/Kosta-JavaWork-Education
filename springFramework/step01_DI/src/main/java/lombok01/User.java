package lombok01;

import lombok.Builder;
import lombok.Data;

/*
 * @Data    : @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor 를 한 번에 적용
 * @Builder : 빌더 패턴 자동 생성 -> User.builder()...build()
 */
@Data
@Builder
public class User {
	private String name;
	private int age;
}
