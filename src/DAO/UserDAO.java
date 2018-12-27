package DAO;

import java.util.List;

import Bean.User;

public interface UserDAO {
	public int addUser(User u) throws DAOException;
	public void deleteUser(int id) throws DAOException;
	public void updataUser(User u) throws DAOException;
	public User getUser(int id) throws DAOException;
	public List<User> searchUser(String name) throws DAOException;
	public void likeComment(int userid, int commentid) throws DAOException;
}
