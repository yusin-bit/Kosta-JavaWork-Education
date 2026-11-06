package sample11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service

public class BookServiceImpl implements BookService {
    
	private final BookDAO bookDAO;
    private final EmailSender emailSender;
    private final MessageSender messageSender;
    
    public BookServiceImpl(BookDAO bookDAO, EmailSender emailSender, MessageSender messageSender) {
    	this.bookDAO = bookDAO;
    	this.emailSender = emailSender;
    	this.messageSender = messageSender;
    }

    @Override
    public void save(BookDTO book1, BookDTO book2) {
        // TODO: 구현
    	System.out.println("서비스 도달 완료");
    	System.out.println("emailSender = " +emailSender);
    	System.out.println("messageSender = " +messageSender);
    	
    	
    	
    	bookDAO.save(emailSender, messageSender, book1, book2);
    	
    }
    
    
    
}
