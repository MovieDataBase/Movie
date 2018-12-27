package Action;
import Bean.*;
import DAO.*;
import java.util.List;

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
	
	// �����Ӱ��Ϣ
	public void Browse(int userid, int movieid) throws DAOException {
		
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		DirectorDAOImpl directorimpl = new DirectorDAOImpl();
		BrouseDAOImpl browseimpl = new BrouseDAOImpl();
		
		// ��ȡ��Ӱ��Ϣ�͵���
		Movie movie = movieimpl.getMovie(movieid);
		List<Director> director = directorimpl.getDirector_byMovie(movieid);
		
		// ��ʾ��Ӱ��Ϣ	
		System.out.println("��Ӱ����" + movie.getMoviename());
		System.out.print("���ݣ�");
		for(int i = 0 ; i < director.size() ; i++) {
			if(i != 0) System.out.print("��");
		    System.out.print(director.get(i).getName());
		}
		System.out.println();
		System.out.println("��磺" + movie.getScreenwriter());
		System.out.println("���ݣ�" + movie.getActor());
		System.out.println("���ͣ�" + movie.getType());
		System.out.println("��Ƭ����/������" + movie.getCountry());
		System.out.println("���ԣ�" + movie.getLanguage());
		System.out.println("��ӳ���ڣ�" + movie.getReleasetime());
		System.out.println("Ƭ����" + movie.getDuration() + "����");
		System.out.println("�����飺" + movie.getIntroduction());
		
		// ��������¼
		Brouse browse = new Brouse();
		browse.setMovieid(movieid);
		browse.setUserid(userid);
		
		browseimpl.addBrouse(browse);
		
	}
	
	// �����ʷ
	public void BrowseList(int userid) throws DAOException {
		
		BrouseDAOImpl browseimpl = new BrouseDAOImpl();
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		UserDAOImpl userimpl = new UserDAOImpl();
		
		// ��ʾ
		System.out.println(userimpl.getUser(userid).getUsername() + " �������¼��");
		List<Brouse> browse = browseimpl.Search(userid);
		for(int i = 0; i < browse.size(); i++) {
			System.out.println("�����Ӱ��" + movieimpl.getMovie(browse.get(i).getMovieid()).getMoviename() + "    ���ʱ�䣺" + browse.get(i).getBrousetime());
		}
		
	}
}
