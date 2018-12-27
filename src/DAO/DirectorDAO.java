package DAO;

import java.util.List;

import Bean.Director;


public interface DirectorDAO {
	
	public void addDirector(Director dir) throws DAOException;
	public void deleteDirector(int id) throws DAOException;
	public void updataDirector(Director dir) throws DAOException;
	public Director getDirector_byId(int id) throws DAOException;
	public List<Director> getDirector_byMovie(int movieid) throws DAOException;
	public List<Director> searchDirector(String name) throws DAOException;
}
