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
	
	// 浏览电影信息
	public void Browse(int userid, int movieid) throws DAOException {
		
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		DirectorDAOImpl directorimpl = new DirectorDAOImpl();
		BrouseDAOImpl browseimpl = new BrouseDAOImpl();
		
		// 获取电影信息和导演
		Movie movie = movieimpl.getMovie(movieid);
		List<Director> director = directorimpl.getDirector_byMovie(movieid);
		
		// 显示电影信息	
		System.out.println("电影名：" + movie.getMoviename());
		System.out.print("导演：");
		for(int i = 0 ; i < director.size() ; i++) {
			if(i != 0) System.out.print("、");
		    System.out.print(director.get(i).getName());
		}
		System.out.println();
		System.out.println("编剧：" + movie.getScreenwriter());
		System.out.println("主演：" + movie.getActor());
		System.out.println("类型：" + movie.getType());
		System.out.println("制片国家/地区：" + movie.getCountry());
		System.out.println("语言：" + movie.getLanguage());
		System.out.println("上映日期：" + movie.getReleasetime());
		System.out.println("片长：" + movie.getDuration() + "分钟");
		System.out.println("剧情简介：" + movie.getIntroduction());
		
		// 添加浏览记录
		Brouse browse = new Brouse();
		browse.setMovieid(movieid);
		browse.setUserid(userid);
		
		browseimpl.addBrouse(browse);
		
	}
	
	// 浏览历史
	public void BrowseList(int userid) throws DAOException {
		
		BrouseDAOImpl browseimpl = new BrouseDAOImpl();
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		UserDAOImpl userimpl = new UserDAOImpl();
		
		// 显示
		System.out.println(userimpl.getUser(userid).getUsername() + " 的浏览记录：");
		List<Brouse> browse = browseimpl.Search(userid);
		for(int i = 0; i < browse.size(); i++) {
			System.out.println("浏览电影：" + movieimpl.getMovie(browse.get(i).getMovieid()).getMoviename() + "    浏览时间：" + browse.get(i).getBrousetime());
		}
		
	}
}
