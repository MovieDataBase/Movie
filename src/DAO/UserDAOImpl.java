package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.User;

public class UserDAOImpl extends DAOBase implements UserDAO{
	
	public static final String ADD_USER_SQL = "INSERT INTO user VALUES (?, ?, ?, ?);";
	@Override
	public void addUser(User u) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ADD_USER_SQL);
			pstmt.setInt(0, u.getUserid());
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.executeQuery(ADD_USER_SQL);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	
	public static final String DELETE_USER_SQL = "DELETE FROM user WHERE userid = ?;";
	@Override
	public void deleteUser(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_USER_SQL);
			pstmt.setInt(0, id);
			pstmt.executeQuery(DELETE_USER_SQL);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	public static final String UPDATE_USER_SQL = "UPDATE user SET username = ?, password = ?, email = ? "
			+ "WHERE userid = ?;";
	@Override
	public void updataUser(User u) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER_SQL);
			pstmt.setString(0, u.getPassword());
			pstmt.setString(1, u.getPassword());
			pstmt.setString(2, u.getEmail());
			pstmt.setInt(3, u.getUserid());
			pstmt.executeUpdate(UPDATE_USER_SQL);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}

	public static final String GET_USER_SQL = "SELECT username, password, email "
			+ "FROM user, WHERE userid = ?;";
	@Override
	public User getUser(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User u = new User();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_USER_SQL);
			pstmt.setInt(0, id);
			rs = pstmt.executeQuery(GET_USER_SQL);
			while(rs.next()) {
				u.setUserid(id);
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				return u;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
		return null;
	}

	// Search for users who's name include ?
	public static final String SEARCH_USER_SQL = "SELECT userid, username, password, email "
			+ "FROM user, WHERE username = %?%;";
	@Override
	public List<User> searchUser(String name) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> userlist = new ArrayList<User>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SEARCH_USER_SQL);
			pstmt.setString(0, name);
			rs = pstmt.executeQuery(SEARCH_USER_SQL);
			while(rs.next()) {
				User u = new User();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				userlist.add(u);
			}
			return userlist;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
		return null;
	}
	

}
