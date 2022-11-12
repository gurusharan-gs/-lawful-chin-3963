package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.model.Employee;
import com.masai.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(String name, String username, String password) {
		
		String message = "Employee Not Registered...!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee(name,username,password) values(?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			
			
		    int x = ps.executeUpdate();
		    
		    if(x > 0) {
		    	message = "Employee Registered Sucessfully !";
		    }
		    
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			message = e.getMessage();
		}
		
		
		
		
		return message;
	}

	@Override
	public String registerEmployee2(Employee employee) {
		
		String message = "Employee Not Registered....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee(name,username,password) values(?,?,?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Employee Registered Sucessfully...!";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			message = e.getMessage();
		}
		
		
		return message;
	}

}
