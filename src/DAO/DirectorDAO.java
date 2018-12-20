package DAO;

import java.util.List;

import Bean.Director;


public interface DirectorDAO {
	
	public void addDirector(Director dir) throws DAOException;
	public void deleteDirector() throws DAOException;
	public void updataDirector(Director dir) throws DAOException;
	public Director getDirector(String id) throws DAOException;
	public List<Director> searchDirector(String name) throws DAOException;
}
