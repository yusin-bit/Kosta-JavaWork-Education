package sample11;

import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {
  
	private final DbUtil dbUtil;
	
	public BookDAOImpl(DbUtil dbUtil) {
		this.dbUtil = dbUtil;
		
	}

    @Override
    public void save(EmailSender emailSender, MessageSender messageSender, BookDTO book1, BookDTO book2) {
        // TODO: 구현
    	System.out.println("DAO 도달 완료");
    	System.out.println("Dbutil = " + dbUtil);
    	
    }
}
