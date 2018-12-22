package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Movie;

public class MovieDAOImpl extends DAOBase implements MovieDAO{
	
	private static final String ADD_MOVIE_SQL =
			"INSERT INTO movie( moviename,screenwriter,actor,type, country, "
			+ "language, releasetime, duration, introduction) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	private static final String UPDATE_MOVIE_SQL =
			"update Movie set moviename=?,screenwriter=?,actor=?,type=?, country=?, "
			+ "language=?, releasetime=?, duration=?, introduction=? where movieid=?";
	private static final String GET_MOVIE_SQL = 
			"select * from Movie where movieid=?";
	private static final String DELETE_MOVIE_SQL = 
			"delete from Movie where movieid=?";
	private static final String SEARCH_MOVIE_SQL = 
			"select * from Movie where moviename like ?";
	
	@Override
	public void addMovie(Movie m) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(ADD_MOVIE_SQL);
			pstmt.setString(1, m.getMoviename());
			pstmt.setString(2, m.getScreenwriter());
			pstmt.setString(3, m.getActor());
			pstmt.setString(4, m.getType());
			pstmt.setString(5, m.getCountry());
			pstmt.setString(6, m.getLanguage());
			pstmt.setDate(7, m.getReleasetime());
			pstmt.setInt(8, m.getDuration());
			pstmt.setString(9, m.getIntroduction());
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("select @@IDENTITY");
			ResultSet i = pstmt.executeQuery();
			if(i.next())
				System.out.println(i.getInt(1));
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		
		
	}

	@Override
	public void updateMovie(Movie m) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_MOVIE_SQL);
			pstmt.setString(1, m.getMoviename());
			pstmt.setString(2, m.getScreenwriter());
			pstmt.setString(3, m.getActor());
			pstmt.setString(4, m.getType());
			pstmt.setString(5, m.getCountry());
			pstmt.setString(6, m.getLanguage());
			pstmt.setDate(7, m.getReleasetime());
			pstmt.setInt(8, m.getDuration());
			pstmt.setString(9, m.getIntroduction());
			pstmt.setInt(10, m.getMovieid());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public Movie getMovie(int movieid) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(GET_MOVIE_SQL);
			pstmt.setInt(1, movieid);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Movie movie = new Movie();
				movie.setMovieid(rs.getInt("movieid"));
				movie.setMoviename(rs.getString("moviename"));
				movie.setScreenwriter(rs.getString("screenwriter"));
				movie.setActor(rs.getString("actor"));
				movie.setType(rs.getString("type"));
				movie.setCountry(rs.getString("country"));
				movie.setLanguage(rs.getString("language"));
				movie.setReleasetime(rs.getDate("releasetime"));
				movie.setDuration(rs.getInt("duration"));
				movie.setIntroduction(rs.getString("introduction"));
				return movie;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return null;
	}

	@Override
	public void deleteMovie(int movieid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_MOVIE_SQL);
			pstmt.setInt(1, movieid);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	@Override
	public List<Movie> Search(String name) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> mList = new ArrayList<Movie>();
		try{
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SEARCH_MOVIE_SQL);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Movie movie = new Movie();
				movie.setMovieid(rs.getInt("movieid"));
				movie.setMoviename(rs.getString("moviename"));
				movie.setScreenwriter(rs.getString("screenwriter"));
				movie.setActor(rs.getString("actor"));
				movie.setType(rs.getString("type"));
				movie.setCountry(rs.getString("country"));
				movie.setLanguage(rs.getString("language"));
				movie.setReleasetime(rs.getDate("releasetime"));
				movie.setDuration(rs.getInt("duration"));
				movie.setIntroduction(rs.getString("introduction"));
				mList.add(movie);
			}
			return mList;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
		return mList;
	}
	
	
}
