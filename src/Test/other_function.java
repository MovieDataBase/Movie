package Test;

import Action.MovieAction;
import DAO.DAOException;

public class other_function {
	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************���Ե�Ӱ��������������**************");
		ma.showMovieByScore();
		System.out.println("**************����ͨ�����ݼ�����Ӱ**************");
		ma.show_movie_by_director(1);
		ma.show_movie_by_director(2);
		System.out.println("**************����ͨ����Ӱ���ͼ�����Ӱ**************");
		ma.search_movie_by_type("����");
		System.out.println("**************�鿴����**************");
		ma.comment_show(1);
		System.out.println("**************���۰���������**************");
		ma.comment_sort(1);
	}
}
