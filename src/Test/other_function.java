package Test;

import Action.MovieAction;
import DAO.DAOException;

public class other_function {
	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************测试电影按照评分排序功能**************");
		ma.showMovieByScore();
		System.out.println("**************测试通过导演检索电影**************");
		ma.show_movie_by_director(1);
		ma.show_movie_by_director(2);
		System.out.println("**************测试通过电影类型检索电影**************");
		ma.search_movie_by_type("动作");
		System.out.println("**************查看评论**************");
		ma.comment_show(1);
		System.out.println("**************评论按点赞排序**************");
		ma.comment_sort(1);
	}
}
