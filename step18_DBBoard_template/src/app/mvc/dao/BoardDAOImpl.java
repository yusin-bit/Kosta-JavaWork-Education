package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;


public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO instance = new BoardDAOImpl();
	
	private BoardDAOImpl() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			 rs = ps.executeQuery();

		        while (rs.next()) {
		        	 BoardDTO bt = new BoardDTO(
		                     rs.getInt("board_no"),
		                     rs.getString("subject"),
		                     rs.getString("writer"),
		                     rs.getString("content"),
		                     rs.getString("board_date")
		                  
		                 );

		                 list.add(bt);
		        }
		 }	catch (SQLException e) {         
			 e.printStackTrace();          
			 throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps, rs);
		 
		 }

		return list;
		
	}
			
			
			
	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board where subject like ? order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" +keyWord +"%");
			
			 rs = ps.executeQuery();

		        while (rs.next()) {
		        	 BoardDTO bt = new BoardDTO(
		                     rs.getInt("board_no"),
		                     rs.getString("subject"),
		                     rs.getString("writer"),
		                     rs.getString("content"),
		                     rs.getString("board_date")
		                  
		                 );

		                 list.add(bt);
		        }
		 }	catch (SQLException e) {         
			 e.printStackTrace();          
			 throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps, rs);
		 
		 }

		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		 BoardDTO bt = null;
	
		String sql="select * from board where board_no = ? ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			 rs = ps.executeQuery();

		        if (rs.next()) {
		        	  bt = new BoardDTO(
		                     rs.getInt("board_no"),
		                     rs.getString("subject"),
		                     rs.getString("writer"),
		                     rs.getString("content"),
		                     rs.getString("board_date")
		                  
		                 );
		        }
		 }	catch (SQLException e) {         
			 e.printStackTrace();          
			 throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps, rs);
		 
		 }

		return  bt;
		
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
	
		String sql="insert into board(subject, writer, content, board_date) values (?, ?, ?, now()) ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			
			
			result =  ps.executeUpdate();

		      
		 }	catch (SQLException e) {         
			 e.printStackTrace();          
			 throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps);
		 
		 }

		return  result;
		
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
	
		String sql="update board set content = ? where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			
			result =  ps.executeUpdate();

		      
		 }	catch (SQLException e) {         
			 e.printStackTrace();          
			 throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps);
		 
		 }

		return  result;
		
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
	
		String sql="delete from reply where board_no = ?";
		String boardSql = "delete from board where board_no = ?";
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			
			result =  ps.executeUpdate();
			
			ps.close();
			
			ps = con.prepareStatement(boardSql);
	        ps.setInt(1, boardNo);

	        result = ps.executeUpdate();
	        
	        con.commit();
	        
		} catch (SQLException e) {

	        e.printStackTrace();

	        try {
	        	
	            if (con != null) {
	                con.rollback();
	            }

		      
		 }	catch (SQLException e2) {         
			 e2.printStackTrace();  
		 }
			 throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps);
		 
		 }

		return  result;
		
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result = 0;
	
		String sql= "insert into reply(reply_content, board_no) values (?, ?)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());
			
			
			result =  ps.executeUpdate();

		      
		 }	catch (SQLException e) {         
			 e.printStackTrace();          
			 throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");

		 } finally {
			 DBManager.releaseConnection(con, ps);
		 
		 }

		return  result;
	}
	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    BoardDTO boardDTO = null;

	    String sql = "select * from board where board_no = ?";

	    try {
	        con = DBManager.getConnection();

	        ps = con.prepareStatement(sql);
	        ps.setInt(1, boardNo);

	        rs = ps.executeQuery();

	        if (rs.next()) {

	            boardDTO = new BoardDTO(
	                    rs.getInt("board_no"),
	                    rs.getString("subject"),
	                    rs.getString("writer"),
	                    rs.getString("content"),
	                    rs.getString("board_date")
	            );

	            List<ReplyDTO> replyList = replySelect(con, boardNo);

	            boardDTO.setRepliesList(replyList);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");

	    } finally {
	        DBManager.releaseConnection(con, ps, rs);
	    }

	    return boardDTO;
	}


	/***
	 * 부모글에 해당하는 댓글정보 가져오기
	 */
	private List<ReplyDTO> replySelect(Connection con, int boardNo)
	        throws SQLException {

	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    List<ReplyDTO> replyList = new ArrayList<>();

	    String sql = "select * from reply where board_no = ?";

	    try {
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, boardNo);

	        rs = ps.executeQuery();

	        while (rs.next()) {

	            ReplyDTO replyDTO = new ReplyDTO(
	                    rs.getInt("reply_no"),
	                    rs.getString("reply_content"),
	                    rs.getInt("board_no"),
	                    rs.getString("reply_regdate")
	            );

	            replyList.add(replyDTO);
	        }

	    } finally {

	        if (rs != null) {
	            rs.close();
	        }

	        if (ps != null) {
	            ps.close();
	        }
	    }

	    return replyList;
	}
}
	













