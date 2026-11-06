package sample11;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
public class BookDTO {
    private String subject;
    private String writer;
    private int price;
    private String date;

}
