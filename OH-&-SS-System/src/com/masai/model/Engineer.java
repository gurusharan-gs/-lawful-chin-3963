package com.masai.model;

public class Engineer {
	
	private int engid;
	private String name;
	private String username;
	private String password;
	private String category;
	
	
	public Engineer() {
		super();
	}


	public Engineer(int engid, String name, String username, String password, String category) {
		super();
		this.engid = engid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
	}


	public int getEngid() {
		return engid;
	}


	public void setEngid(int engid) {
		this.engid = engid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Engineer [engid=" + engid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", category=" + category + "]";
	}
	
	
	


}
