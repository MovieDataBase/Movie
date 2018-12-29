package DAO;
import java.util.List;
import Bean.*;

public interface CommentDAO {

	public boolean addComment(Comment m) throws DAOException;
	public boolean updateComment(Comment m) throws DAOException;
	public Comment getComment(int commentid) throws DAOException;
	public boolean deleteComment(int commentid) throws DAOException;
	public List<Comment> Search(int commentid) throws DAOException;
	public int likeComment(int commentid) throws DAOException;
}