package DAO;
import java.util.List;
import Bean.*;

public interface BrouseDAO {
		
	public void addBrouse(Brouse b) throws DAOException;
	public void updateBrouse(Brouse b) throws DAOException;
	public Brouse getBrouse(int brouseid) throws DAOException;
	public void deleteBrouse(int brouseid) throws DAOException;
	public List<Brouse> Search(int userid) throws DAOException;
		
}
