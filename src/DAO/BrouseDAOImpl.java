package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.Brouse;

public class BrouseDAOImpl extends DAOBase implements BrouseDAO {
	
	private static final String ADD_BROUSE_SQL =
			"INSERT INTO brouse(brouseid, userid, movieid) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_BROUSE_SQL =
			"update brouse set userid=?, movieid=?, brousetime=? where brouseid=?";
	private static final String GET_BROUSE_SQL = 
			"select * from brouse where brouseid=?";
	private static final String DELETE_BROUSE_SQL = 
			"delete from brouse where brouseid=?";
	private static final String SEARCH_BROUSE_SQL = 
			"select * from brouse where userid=?";

	@Override
	public void addBrouse(Brouse b) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(ADD_BROUSE_SQL);
			pstmt.setInt(1, b.getUserid());
			pstmt.setInt(2, b.getMovieid());
			pstmt.setDate(3, b.getBrousetime());
			pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public void updateBrouse(Brouse b) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_BROUSE_SQL);
			pstmt.setInt(1, b.getUserid());
			pstmt.setInt(2, b.getMovieid());
			pstmt.setDate(3, b.getBrousetime());
			pstmt.setInt(4, b.getBrouseid());
			pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public Brouse getBrouse(int brouseid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(GET_BROUSE_SQL);
			pstmt.setInt(1, brouseid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("brouseid") + " " + rs.getInt("userid") + " " + rs.getInt("movieid") + " " + rs.getDate("brousedate"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return null;
	}

	@Override
	public void deleteBrouse(int brouseid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_BROUSE_SQL);
			pstmt.setInt(1, brouseid);
			pstmt.executeQuery();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public List<Brouse> Search(int userid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SEARCH_BROUSE_SQL);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("brouseid") + " " + rs.getInt("userid") + " " + rs.getInt("movieid") + " " + rs.getDate("brousedate"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return null;
	}

}
