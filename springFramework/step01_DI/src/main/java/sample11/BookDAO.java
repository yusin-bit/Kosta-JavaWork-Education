package sample11;

import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO {
    void save(EmailSender emailSender, MessageSender messageSender, BookDTO book1, BookDTO book2);
}
