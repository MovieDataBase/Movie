package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Browse;
import Bean.Comment;

public class BrowseDAOImpl extends DAOBase implements BrowseDAO {
	
	private static final String ADD_browse_SQL =
			"INSERT INTO [browse](userid, movieid) VALUES (?, ?)";
	private static final String UPDATE_browse_SQL =
			"update [browse] set userid=?, movieid=?, browsetime=? where browseid=?";
	private static final String GET_browse_SQL = 
			"select * from [browse] where browseid=?";
	private static final String DELETE_browse_SQL = 
			"delete from [browse] where browseid=?";
	private static final String SEARCH_browse_SQL = 
			"select * from [browse] where userid=?";

	@Override
	public void addbrowse(Browse b) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(ADD_browse_SQL);
			pstmt.setInt(1, b.getUserid());
			pstmt.setInt(2, b.getMovieid());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public void updatebrowse(Browse b) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_browse_SQL);
			pstmt.setInt(1, b.getUserid());
			pstmt.setInt(2, b.getMovieid());
			pstmt.setString(3, b.getbrowsetime());
			pstmt.setInt(4, b.getbrowseid());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public Browse getbrowse(int browseid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(GET_browse_SQL);
			pstmt.setInt(1, browseid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.next())
				{
					Browse browse = new Browse();
					browse.setbrowseid(browseid);
					browse.setUserid(rs.getInt("userid"));
					browse.setMovieid(rs.getInt("movieid"));
					browse.setbrowsetime(rs.getString("browsetime"));

					return browse;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return null;
	}

	@Override
	public void deletebrowse(int browseid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_browse_SQL);
			pstmt.setInt(1, browseid);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public List<Browse> Search(int userid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Browse> broList = new ArrayList<Browse>();
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SEARCH_browse_SQL);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Browse browse = new Browse();
				browse.setbrowseid(rs.getInt("browseid"));
				browse.setUserid(rs.getInt("userid"));
				browse.setMovieid(rs.getInt("movieid"));
				browse.setbrowsetime(rs.getString("browsetime"));
				broList.add(browse);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return broList;
	}

}
