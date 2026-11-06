package db.util;

/**
 *  DB 설정 정보들을 상수로 관리
 * */
public interface DbProperties {
	
	   public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	   String URL="jdbc:mysql://localhost:3306/ex0828";
	   String USER_ID="YOUR_DB_USER";
	   String USER_PASS="YOUR_DB_PASSWORD";
	   
	//////ORACLE Connection////////////////////
//    public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//    String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//    String USER_ID = "YOUR_DB_USER";
//    String USER_PASS = "YOUR_DB_PASSWORD";
	

		  
}
