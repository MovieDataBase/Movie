package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOBase implements DAO{

	@Override
	public Connection getConnection(){
		try {
			Connection conn = C3P0JdbcUtil.getConnection();
			return conn;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
