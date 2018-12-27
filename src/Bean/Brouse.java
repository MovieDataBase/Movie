package Bean;
import java.sql.Date;

public class Brouse {
	
	private int brouseid;
	private int userid;
	private int movieid;
	private Date brousetime;
	
	public int getBrouseid() {
		return brouseid;
	}
	public void setBrouseid(int brouseid) {
		this.brouseid = brouseid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public Date getBrousetime() {
		return brousetime;
	}
	public void setBrousetime(Date brousetime) {
		this.brousetime = brousetime;
	}
	
}
