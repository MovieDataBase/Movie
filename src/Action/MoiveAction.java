package Action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.Formatter;

import Bean.*;
import DAO.*;

class CommentGrade implements Comparable {
	
	Comment c;
	Integer cnt;
	
	public CommentGrade(Comment c, Integer cnt)
	{
		this.c = c;
		this.cnt = cnt;
	}
	
	public Comment getC() {
		return c;
	}
	public Integer getCnt() {
		return cnt;
	}

	@Override
	public int compareTo(Object b) {
		
		CommentGrade  cg = (CommentGrade)b;
		if(cg.cnt >= this.cnt) return 1;
		return cg.getCnt().compareTo(this.cnt);
	}
	
}
class Composite implements Comparable {
	Movie m;
	double b;
	public Composite(Movie m,Double b)
	{
		
		if(Double.isNaN(b))
			this.b = -1;
		else
			this.b = b;
		this.m = m;
	}
	public Movie getM() {
		return m;
	}
	public void setM(Movie m) {
		this.m = m;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	public int compareTo(Object b)
	{ 
	     Composite com=(Composite)b;
	     if(com.getB()-this.getB()>=0)
	    	 return 1;
	     else 
	    	 return -1;
	     
	 }
	
}

public class MoiveAction {
	
	public void showMovieByScore() throws DAOException{
		MovieDAOImpl mImpl = new MovieDAOImpl();
		List<Movie> mList = mImpl.allMovies();
		Iterator<Movie> it = mList.iterator();
		TreeSet<Composite> col=new TreeSet<Composite>();
		while(it.hasNext())
		{
			Movie m = (Movie)it.next();
			col.add(new Composite(m,mImpl.getScore(m.getMovieid())));
		}
		Formatter formatter = new Formatter(System.out);
		
		
	     Iterator<Composite> iter=col.iterator();
    	 System.out.println("��Ӱ����"+"\t\t\t"+"����");
	     while(iter.hasNext())
	     { 
	    	 Composite com = (Composite)iter.next();

	    	 if(com.getB()==-1)
	    	 {
	    		 System.out.println(com.getM().getMoviename()+"\t\t\t"+"��������");
//	    		 formatter.format("%-100s %5s\n", com.getM().getMoviename(),"��������");
	    	 }    		 
	    	 else
	    	 {
	    		 System.out.println(com.getM().getMoviename()+"\t\t\t"+com.getB());
//	    		 Double db = new Double(com.getB());
//	    		 formatter.format("%-100s %5d\n", com.getM().getMoviename(),com.getB());
	    	 }
	    		 
	     }
	}
	
	public void show_movie_by_director(int directorid) throws DAOException {
		MovieDAOImpl mImpl = new MovieDAOImpl();
		List<Movie> mlist;
		mlist = mImpl.getMovie_byDirector(directorid);
		if(mlist.size() == 0)
			System.out.println("�޸õ���ָ���ĵ�Ӱ");
		else {
			System.out.println("ָ�����ĵ�Ӱ����: ");
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
			System.out.println("�޸����͵ĵ�Ӱ");
		else {
			System.out.println(type + "���Ӱ����: ");
			for(int i = 0; i < mlist.size(); i++) {
				System.out.print("��Ӱ��: " + mlist.get(i).getMoviename() + " ");
				System.out.println("���: " + mlist.get(i).getType());
			}
		}
	}
	
	// �鿴����
	public void comment_show(int movieid) throws DAOException {
		
		CommentDAOImpl commentimpl = new CommentDAOImpl();
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		UserDAOImpl userimpl = new UserDAOImpl();
		List<Comment> cList = commentimpl.Search(movieid);
		
		System.out.println("��Ӱ����\t" + movieimpl.getMovie(movieid).getMoviename());
		System.out.println("�������ۣ�");
		for(int i = cList.size() - 1; i >= 0; i--) {
			System.out.println("�����ˣ�" + userimpl.getUser(cList.get(i).getUserid()).getUsername());
			System.out.println("����ʱ�䣺" + cList.get(i).getTime());
			System.out.println("��֣�" + cList.get(i).getScore());
			System.out.println("��������" + commentimpl.likeComment(cList.get(i).getCommentid()));
			System.out.println("�������ݣ�");
			System.out.println(cList.get(i).getText());
		}
		System.out.println();
	}
	
	// �������
	public void comment(int userid, int movieid, String text, int score) throws DAOException {
		
		CommentDAOImpl commentimpl = new CommentDAOImpl();
		
		Comment c = new Comment();
		c.setUserid(userid);
		c.setMovieid(movieid);
		c.setText(text);
		c.setScore(score);
		
		commentimpl.addComment(c);
	}
	
	// ɾ������
	public void comment_delete(int userid, int commentid) throws DAOException {
		
		CommentDAOImpl commentimpl = new CommentDAOImpl();
		
		Comment c = commentimpl.getComment(commentid);
		if(c.getUserid() != userid) {
			System.out.println("ɾ��ʧ�ܣ���û��Ȩ��ɾ�����˵�����");
			return;
		}
		
		commentimpl.deleteComment(commentid);
		System.out.println("ɾ���ɹ�");
	}
	
	// �޸�����
	public void comment_update(int userid, int commentid, String text, int score) throws DAOException {
		
		CommentDAOImpl commentimpl = new CommentDAOImpl();
		
		Comment c = commentimpl.getComment(commentid);
		if(c.getUserid() != userid) {
			System.out.println("�޸�ʧ�ܣ���û��Ȩ���޸ı��˵�����");
			return;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		c.setTime(date);
		c.setText(text);
		c.setScore(score);
		
		commentimpl.updateComment(c);
		System.out.println("�޸ĳɹ�");
	}
		
	// ���۰���������
	public void comment_sort(int movieid) throws DAOException {
		
		CommentDAOImpl commentimpl = new CommentDAOImpl();
		MovieDAOImpl movieimpl = new MovieDAOImpl();
		UserDAOImpl userimpl = new UserDAOImpl();
		
		// ����
		TreeSet<CommentGrade> col=new TreeSet<CommentGrade>();
		List<Comment> cList = commentimpl.Search(movieid);
		Iterator<Comment> it = cList.iterator();
		while(it.hasNext())
		{
			Comment comment = (Comment)it.next();
			col.add(new CommentGrade( comment,commentimpl.likeComment(comment.getCommentid())));
		}
		
		// ���
		System.out.println("��Ӱ����\t" + movieimpl.getMovie(movieid).getMoviename());
		System.out.println("�������ۣ�������������");
		Iterator<CommentGrade> itr = col.iterator();
		
		while(itr.hasNext()) {
			CommentGrade comment = (CommentGrade)itr.next();
			
			System.out.println("�����ˣ�" + userimpl.getUser(comment.getC().getUserid()).getUsername());
			System.out.println("����ʱ�䣺" + comment.getC().getTime());
			System.out.println("��֣�" + comment.getC().getScore());
			System.out.println("��������" + commentimpl.likeComment(comment.getC().getCommentid()));
			System.out.println("�������ݣ�");
			System.out.println(comment.getC().getText());
		}
		System.out.println();
		
	}
	
}
