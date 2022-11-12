package com.masai.model;

public class Employee {
	
	
	private int empid;
	private String name;
	private String username;
	private String password;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int empid, String name, String username, String password) {
		super();
		this.empid = empid;
		this.name = name;
		this.username = username;
		this.password = password;
	}


	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
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


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
	
	

}
