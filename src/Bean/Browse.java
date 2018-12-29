package Bean;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Browse {
	
	private int browseid;
	private int userid;
	private int movieid;
	private String browsetime;
	
	public int getbrowseid() {
		return browseid;
	}
	public void setbrowseid(int browseid) {
		this.browseid = browseid;
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
	public String getbrowsetime() {
		return browsetime;
	}
	public void setbrowsetime(String browsetime) {
		this.browsetime = browsetime;
	}
	
}
