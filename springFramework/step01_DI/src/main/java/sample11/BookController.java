package sample11;

import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	
    private final BookService bookService;
    private final BookDTO book1;
    private final BookDTO book2;
    
    public BookController(BookService bookService, BookDTO book1, BookDTO book2) {
    	this.book1 = book1;
    	this.book2 = book2;
    	this.bookService = bookService;
    	
    }

    public void invoker() {
        System.out.println("입력 받은 book1 = " + book1);
        System.out.println("입력 받은 book2 = " + book2);
        System.out.println("입력 받은 bookService = " + bookService);
        
        bookService.save(book1, book2);
        
    }
}
