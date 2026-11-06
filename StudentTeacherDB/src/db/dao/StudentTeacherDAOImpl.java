package db.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.vo.Student;
import db.vo.Teacher;
import db.util.DbManager;
import db.vo.Subject;
import db.vo.Room;

public class StudentTeacherDAOImpl implements StudentTeacherDAO{

	@Override
	public List<Student> getGenderByWomen() {
		
		
		List<Student> list = new ArrayList<Student>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from student where 수_주민등록번호 like ?";
		
		try {
			
			 con = DbManager.getConnection();

		        ps = con.prepareStatement(sql);

		        ps.setString(1, "%-2%");

		        rs = ps.executeQuery();

		        while (rs.next()) {
		        	 Student student = new Student(
		                     rs.getInt("수강생번호"),
		                     rs.getString("수_이름"),
		                     rs.getString("수_주민등록번호"),
		                     rs.getString("수_전화번호"),
		                     rs.getString("수_주소"),
		                     rs.getString("수_이메일")
		                 );

		                 list.add(student);
		        }
		 }	catch (SQLException e) {         
			 e.printStackTrace();          

		 } finally {
			 DbManager.dbClose(con, ps, rs);
		 
		 }

		return list;
		
	}

	@Override
	public List<Teacher> getTeacherInfoByAddr(String gu) {
		
		List<Teacher> list = new ArrayList<Teacher>();

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    String sql = "select * from teacher where 강_주소 like ?";

	    try {

	        con = DbManager.getConnection();

	        ps = con.prepareStatement(sql);

	        ps.setString(1, "%" + gu + "%");

	        rs = ps.executeQuery();

	        while (rs.next()) {

	            Teacher teacher = new Teacher(
	                rs.getInt("강사번호"),
	                rs.getString("강_이름"),
	                rs.getString("강_주민등록번호"),
	                rs.getString("강_전화번호"),
	                rs.getString("강_주소"),
	                rs.getString("강_이메일"),
	                rs.getString("수강코드")
	            );

	            list.add(teacher);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();

	    } finally {
	        DbManager.dbClose(con, ps, rs);
	    }

	    return list;
	}

	@Override
	public Teacher getTeacherInfoBySubject(String subject) {
		// TODO Auto-generated method stub
		Teacher teacher = null;

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    String sql =
	        "select * from teacher "
	      + "where 수강코드 = "
	      + "(select 수강코드 from subject "
	      + "where upper(과목) = upper(?))";

	    try {

	        con = DbManager.getConnection();

	        ps = con.prepareStatement(sql);

	        ps.setString(1, subject);

	        rs = ps.executeQuery();

	        if (rs.next()) {

	            teacher = new Teacher(
	                rs.getInt("강사번호"),
	                rs.getString("강_이름"),
	                rs.getString("강_주민등록번호"),
	                rs.getString("강_전화번호"),
	                rs.getString("강_주소"),
	                rs.getString("강_이메일"),
	                rs.getString("수강코드")
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();

	    } finally {
	        DbManager.dbClose(con, ps, rs);
	    }

	    return teacher;
	}

	@Override
	public Teacher getTeacherInfoByNo(int teacherNo) {
		 Teacher teacher = null;

		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;

		    String sql = "select * from v_tear where 강사번호 = ?";

		    try {

		        con = DbManager.getConnection();

		        ps = con.prepareStatement(sql);

		        ps.setInt(1, teacherNo);

		        rs = ps.executeQuery();

		        if (rs.next()) {

		            Subject subject = new Subject(
		                rs.getString("수강코드"),
		                rs.getString("과목")
		            );

		            Room room = new Room(
		                rs.getInt("강의실번호"),
		                rs.getInt("수용인원")
		            );

		            teacher = new Teacher();

		            teacher.setTeacherNo(rs.getInt("강사번호"));
		            teacher.setTeacherName(rs.getString("강사이름"));

		            teacher.setSubject(subject);
		            teacher.setRoom(room);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();

		    } finally {
		        DbManager.dbClose(con, ps, rs);
		    }

		    return teacher;
	}

}
