package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Director;
import Bean.User;

public class DirectorDAOImpl extends DAOBase implements DirectorDAO{

	public static final String ADD_DIRECTOR_SQL = "INSERT INTO director VALUES (?, ?, ?, ?, ?, ?);";
	@Override
	public void addDirector(Director dir) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ADD_DIRECTOR_SQL);
			pstmt.setInt(0, dir.getDirectorid());
			pstmt.setString(1, dir.getName());
			pstmt.setString(2, dir.getSex());
			pstmt.setDate(3, dir.getBirthday());
			pstmt.setString(4, dir.getBirthplace());
			pstmt.setString(5, dir.getProfile());
			pstmt.executeQuery(ADD_DIRECTOR_SQL);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}

	public static final String DELETE_DIRECTOR_SQL = "DELETE FROM director WHERE directorid = ?;";
	@Override
	public void deleteDirector(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_DIRECTOR_SQL);
			pstmt.setInt(0, id);
			pstmt.executeQuery(DELETE_DIRECTOR_SQL);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}

	public static final String UPDATE_DIRECTOR_SQL = "UPDATE director SET name = ?, sex = ?, birthday = ?, birthplace = ?,profile = ? "
			+ "WHERE directorid = ?;";
	@Override
	public void updataDirector(Director dir) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_DIRECTOR_SQL);
			pstmt.setString(0, dir.getName());
			pstmt.setString(1, dir.getSex());
			pstmt.setDate(2, dir.getBirthday());
			pstmt.setString(3, dir.getBirthplace());
			pstmt.setString(4, dir.getProfile());
			pstmt.executeUpdate(UPDATE_DIRECTOR_SQL);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}

	public static final String GET_USER_SQL = "SELECT name, sex, birthday, birthday, birthplace, profile "
			+ "FROM director, WHERE directorid = ?;";
	@Override
	public Director getDirector(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Director d = new Director();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_USER_SQL);
			pstmt.setInt(0, id);
			rs = pstmt.executeQuery(GET_USER_SQL);
			while(rs.next()) {
				d.setDirectorid(id);
				d.setName(rs.getString("name"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getDate("birthday"));
				d.setBirthplace(rs.getString("birthplace"));
				d.setProfile(rs.getString("profile"));
				return d;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
		return null;
	}

	public static final String SEARCH_DIRECTOR_SQL = "SELECT name, sex, birthday, birthplace, profile "
			+ "FROM director, WHERE name = %?%;";
	@Override
	public List<Director> searchDirector(String name) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Director> directorlist = new ArrayList<Director>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SEARCH_DIRECTOR_SQL);
			pstmt.setString(0, name);
			rs = pstmt.executeQuery(SEARCH_DIRECTOR_SQL);
			while(rs.next()) {
				Director d = new Director();
				d.setDirectorid(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getDate("birthday"));
				d.setBirthplace(rs.getString("birthplace"));
				d.setProfile(rs.getString("profile"));
				directorlist.add(d);
			}
			return directorlist;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
		return null;
	}


	
}
