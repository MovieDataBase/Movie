package Action;


import java.util.Iterator;
import java.util.List;

import java.util.TreeSet;
import java.util.Formatter;
import Bean.*;
import DAO.*;


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
    	 System.out.println("电影名称"+"\t\t\t"+"评分");
	     while(iter.hasNext())
	     { 
	    	 Composite com = (Composite)iter.next();

	    	 if(com.getB()==-1)
	    	 {
	    		 System.out.println(com.getM().getMoviename()+"\t\t\t"+"暂无评分");
//	    		 formatter.format("%-100s %5s\n", com.getM().getMoviename(),"暂无评分");
	    	 }    		 
	    	 else
	    	 {
	    		 System.out.println(com.getM().getMoviename()+"\t\t\t"+com.getB());
//	    		 Double db = new Double(com.getB());
//	    		 formatter.format("%-100s %5d\n", com.getM().getMoviename(),com.getB());
	    	 }
	    		 
	     }
	     
	     
		

	}
	
}
