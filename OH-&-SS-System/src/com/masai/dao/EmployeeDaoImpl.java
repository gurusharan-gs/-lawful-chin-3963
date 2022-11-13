package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Complain;
import com.masai.model.Employee;
import com.masai.model.Eng_Com;
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

	@Override
	public String loginEmployee(String username, String password) throws EmployeeException {
		
		String message = "Invalid Credentials";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				message = " Welcome "+ name;
			}else {
				message = "Wrong Credentials";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw new EmployeeException("Employee Not Found...!");
		}
		
		
		return message;
		
	}

	
	
	@Override
	public String registerComplain(String complainname, String category) {

		String message = "Complain Not Assigned...!";
		
		try (Connection conn =  DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into complain(ComplainName,Category) values(?,?)");
			
			ps.setString(1, complainname);
			ps.setString(2, category);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Complain Assigned Sucessfully... !";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception	
			message = e.getMessage();
		}
				
		return message;
	}

	@Override
	public List<Eng_Com> ComplainStatus(int EcomplainId) throws ComplainException {


		List<Eng_Com> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from EngineerComplain where EcomplainId = ?");
			
			ps.setInt(1, EcomplainId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int engid = rs.getInt("engid");
				String name = rs.getString("name");
				String category = rs.getString("Category");
				int complainId = rs.getInt("EComplainId");
				String status = rs.getString("ComplainStatus");
				
				Eng_Com ec = new Eng_Com(engid, name, category, EcomplainId, status);
				
				list.add(ec);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ComplainException(e.getMessage());
		}
		if(list.size()==0) {
			throw new ComplainException("No Complain Found !!!!");
		}
		
		return list;
		
	}

	@Override
	public List<Complain> getComplainHistory(int empid) throws EmployeeException {

		List<Complain> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Complain where empid = ?");
			ps.setInt(1, empid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int ComplainId = rs.getInt("ComplainId");
				String ComplainName = rs.getString("ComplainName");
				String Category = rs.getString("Category");
				
				Complain com = new Complain(ComplainId, ComplainName, Category);
				
			    list.add(com);
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return list;

	}

	@Override
	public String changePassword(String password, int empid) throws EmployeeException {
	
		String message = "Password Not Changed...!";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Update Employee set password = ? where empid = ?");
			
			ps.setString(1, password);
			ps.setInt(2, empid);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Password Updated Sucessfull...";
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
	
		
		return message;
	}

}

























