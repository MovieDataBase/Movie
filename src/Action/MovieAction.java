package Action;
import java.util.Iterator;
import java.util.List;

import Bean.*;
import DAO.*;


public class MovieAction {
	public void show_movie_by_director(int directorid) throws DAOException {
		MovieDAOImpl mImpl = new MovieDAOImpl();
		List<Movie> mlist;
		mlist = mImpl.getMovie_byDirector(directorid);
		if(mlist.size() == 0)
			System.out.println("无该导演指导的电影");
		else {
			System.out.println("指导过的电影包括: ");
			Iterator<Movie> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getMoviename());
			}
		}
	}
	
	public void search_movie_by_type(String type) throws DAOException {
		MovieDAOImpl mImpl = new MovieDAOImpl();
		List<Movie> mlist;
		mlist = mImpl.Search_byType(type);
		if(mlist.size() == 0)
			System.out.println("无该类型的电影");
		else {
			System.out.println(type + "类电影包括: ");
			Iterator<Movie> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.print("电影名: " + it.next().getMoviename() + " ");
				System.out.println("类别: " + it.next().getType());
			}
		}
	}
	
}