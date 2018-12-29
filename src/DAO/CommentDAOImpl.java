package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Comment;
import Bean.Movie;

public class CommentDAOImpl extends DAOBase implements CommentDAO{

	private static final String ADD_COMMENT_SQL =
			"INSERT INTO comment( userid,movieid,text,score)"
			+ " VALUES (?, ?, ?, ?) ";
	private static final String UPDATE_COMMENT_SQL =
			"update Comment set userid=?, movieid=?, text=?, "
			+ "time=?, score=? where movieid=?";
	private static final String GET_COMMENT_SQL = 
			"select * from Comment where commentid=?";
	private static final String DELETE_COMMENT_SQL = 
			"delete from Comment where commentid=?";
	private static final String SEARCH_COMMENT_SQL = 
			"select * from Comment where movieid=?";
	private static final String LIKE_COMMENT_SQL =
			"select * from [like] where commentid=?";
	
	@Override
	public void addComment(Comment m) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(ADD_COMMENT_SQL);
			pstmt.setInt(1, m.getUserid());
			pstmt.setInt(2, m.getMovieid());
			pstmt.setString(3, m.getText());
			pstmt.setInt(4, m.getScore());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}
	@Override
	public void updateComment(Comment m) throws DAOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_COMMENT_SQL);
			pstmt.setInt(1, m.getUserid());
			pstmt.setInt(2, m.getMovieid());
			pstmt.setString(3, m.getText());
			pstmt.setString(4, m.getTime());
			pstmt.setInt(5, m.getScore());
			pstmt.setInt(6, m.getMovieid());

			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}
	@Override
	public Comment getComment(int commentid) throws DAOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(GET_COMMENT_SQL);
			pstmt.setInt(1, commentid);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Comment comment = new Comment();
				comment.setCommentid(commentid);
				comment.setUserid(rs.getInt("userid"));
				comment.setMovieid(rs.getInt("movieid"));
				comment.setText(rs.getString("text"));
				comment.setTime(rs.getString("time"));
				comment.setScore(rs.getInt("score"));
				
				return comment;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return null;
	}
	@Override
	public void deleteComment(int commentid) throws DAOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_COMMENT_SQL);
			pstmt.setInt(1, commentid);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}
	@Override
	public List<Comment> Search(int movieid) throws DAOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> comList = new ArrayList<Comment>();
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SEARCH_COMMENT_SQL);
			pstmt.setInt(1,movieid);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Comment comment = new Comment();
				comment.setCommentid(rs.getInt("commentid"));
				comment.setUserid(rs.getInt("userid"));
				comment.setMovieid(rs.getInt("movieid"));
				comment.setText(rs.getString("text"));
				comment.setTime(rs.getString("time"));
				comment.setScore(rs.getInt("score"));
				comList.add(comment);
			}
			return comList;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return comList;
	}
	
	@Override
	public int likeComment(int commentid) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(LIKE_COMMENT_SQL);
			pstmt.setInt(1, commentid);
			rs = pstmt.executeQuery();
			
			int like_num = 0;
			while(rs.next()) like_num++;
			return like_num;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}		
		return 0;
	}

}
	
	
