package Bean;

import java.sql.Date;

public class Director {
	private int directorid;
	private String name;
	private String sex;
	private Date birthday;
	private String birthplace;
	private String profile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getDirectorid() {
		return directorid;
	}
	public void setDirectorid(int directorid) {
		this.directorid = directorid;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
}
