package DAO;
import java.util.List;
import Bean.*;

public interface MovieDAO {
	
	public void addMovie(Movie m) throws DAOException;
	public void updateMovie(Movie m) throws DAOException;
	public Movie getMovie(int movieid) throws DAOException;
	public void deleteMovie(int movieid) throws DAOException;
	public List<Movie> Search(String name) throws DAOException;
	public List<Movie> Search_byType(String type) throws DAOException;
	public List<Movie> getMovie_byDirector(int directorid) throws DAOException;
}
