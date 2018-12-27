package Action;
import DAO.*;
import Bean.*;

public class UserAction {
	
	
	
	public int register(User u) throws DAOException {
		UserDAOImpl uImpl = new UserDAOImpl();
		return uImpl.addUser(u);
	}
	
	public boolean login(int id, String password) throws DAOException {
		UserDAOImpl uImpl = new UserDAOImpl();
		if(password.equals(uImpl.getUser(id).getPassword()))
			return true;
		return false;
	}
	
	public boolean like_comment(int userid, int commentid) throws DAOException {
		UserDAOImpl uImpl = new UserDAOImpl();
		uImpl.likeComment(userid, commentid);
		return true;
	}
	
}
