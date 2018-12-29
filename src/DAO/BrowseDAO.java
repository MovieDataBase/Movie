package DAO;
import java.util.List;
import Bean.*;

public interface BrowseDAO {
		
	public void addbrowse(Browse b) throws DAOException;
	public void updatebrowse(Browse b) throws DAOException;
	public Browse getbrowse(int browseid) throws DAOException;
	public void deletebrowse(int browseid) throws DAOException;
	public List<Browse> Search(int userid) throws DAOException;
		
}
