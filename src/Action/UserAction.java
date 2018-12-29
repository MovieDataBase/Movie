package Action;
import Bean.*;
import DAO.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class UserAction {
	
	public void register(User u) throws DAOException {
		UserDAOImpl uImpl = new UserDAOImpl();
		int id = uImpl.addUser(u);
		if(id == -1)
			System.out.println("用户名已经存在");
		else
			System.out.println("注册成功，用户ID: " + id);
	}
	
	public int login(int id, String password) throws DAOException {
		UserDAOImpl uImpl = new UserDAOImpl();
		if(password.equals(uImpl.getUser(id).getPassword())) {
			System.out.println("登录成功");
			return id;
		}
		else
			System.out.println("密码错误，登录失败");
		return -1;
	}
	
	public void like_comment(int userid, int commentid) throws DAOException {
		UserDAOImpl uImpl = new UserDAOImpl();
		if(uImpl.likeComment(userid, commentid) == true)
			System.out.println("点赞成功");
		else
			System.out.println("已点赞过");
	}
	
	// 浏览电影信息
	public void Browse(int userid, int movieid) throws DAOException {
		
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		DirectorDAOImpl directorimpl = new DirectorDAOImpl();
		BrowseDAOImpl browseimpl = new BrowseDAOImpl();
		CommentDAOImpl commentimpl = new CommentDAOImpl();
		
		// 获取电影信息、导演和评论数
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
		System.out.println("评论数：" + commentimpl.Search(movieid).size());
		System.out.println("剧情简介：\n       " + movie.getIntroduction());
		System.out.println();
		
		// 添加浏览记录
		Browse browse = new Browse();
		browse.setMovieid(movieid);
		browse.setUserid(userid);
		
		browseimpl.addbrowse(browse);
		
	}
	
	// 浏览历史
	public void BrowseList(int userid) throws DAOException {
		
		BrowseDAOImpl browseimpl = new BrowseDAOImpl();
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		UserDAOImpl userimpl = new UserDAOImpl();
		
		// 显示
		System.out.println(userimpl.getUser(userid).getUsername() + " 的浏览记录：");
		List<Browse> browse = browseimpl.Search(userid);
		
		for(int i = browse.size() - 1; i >= 0; i--) {
			System.out.println("浏览电影：" + movieimpl.getMovie(browse.get(i).getMovieid()).getMoviename() + "\t浏览时间：" + browse.get(i).getbrowsetime());
		}
		System.out.println();
	}
	
}
