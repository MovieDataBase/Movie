package DAO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class C3P0JdbcUtil {
	private static ComboPooledDataSource ds = null;
	
	static {
		try {
			ds = new ComboPooledDataSource("SQLServer");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
