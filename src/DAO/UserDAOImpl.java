package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.User;

public class UserDAOImpl extends DAOBase implements UserDAO{
	
	public static final String ADD_USER_SQL = "INSERT INTO [user] VALUES (?, ?, ?, ?);";
	@Override
	public int addUser(User u) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ADD_USER_SQL);
			pstmt.setInt(1, u.getUserid());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.executeQuery();
			pstmt = conn.prepareStatement("select @@IDENTITY");
			ResultSet i = pstmt.executeQuery();
			if(i.next())
				return i.getInt(1);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return -1;
	}

	
	public static final String DELETE_USER_SQL = "DELETE FROM [user] WHERE userid = ?;";
	@Override
	public void deleteUser(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_USER_SQL);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	public static final String UPDATE_USER_SQL = "UPDATE [user] SET username = ?, password = ?, email = ? "
			+ "WHERE userid = ?;";
	@Override
	public void updataUser(User u) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER_SQL);
			pstmt.setString(1, u.getPassword());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setInt(4, u.getUserid());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
	}

	public static final String GET_USER_SQL = "SELECT username, password, email "
			+ "FROM [user], WHERE userid = ?;";
	@Override
	public User getUser(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User u = new User();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_USER_SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
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
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		
		return null;
	}

	// Search for users who's name include ?
	public static final String SEARCH_USER_SQL = "SELECT userid, username, password, email "
			+ "FROM [user], WHERE username = %?%;";
	@Override
	public List<User> searchUser(String name) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> userlist = new ArrayList<User>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SEARCH_USER_SQL);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
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
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		
		return null;
	}
	
	
	public static final String LIKE_COMMENT_SQL = "INSERT INTO [like] VALUES(?, ?);";
	@Override
	public void likeComment(int userid, int commentid) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(LIKE_COMMENT_SQL);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, commentid);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
		
	}
	

}
