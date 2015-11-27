package cn.zucc.entity;

public class User {
	private int id;
	private int sex;//1ÄÐ0Å®¡¢
	private String name;
	private String password;
	private String hobby;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "User [hobby=" + hobby + ", id=" + id + ", name=" + name
				+ ", password=" + password + ", sex=" + sex + "]";
	}
	

}
