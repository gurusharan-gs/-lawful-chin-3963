package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.model.Complain;
import com.masai.model.Engineer;
import com.masai.utility.DBUtil;

public class HODRollsDaoImpl implements HODRollsDao{

	@Override
	public String loginIntoSystem(String username, String password) throws HodException{
		
		String messege = "Invalid User...";

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from loginhod where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				messege = " WelCome " + name;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		

		
		return messege;
	}
	
	

	@Override
	public String registerEngineer(Engineer engineer) {
	
		String messege = "Engineer Not Register";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Engineer(name, username, password, Category) values(?,?,?,?)");
			
			ps.setString(1, engineer.getName());
			ps.setString(2, engineer.getUsername());
			ps.setString(3, engineer.getPassword());
			ps.setString(4, engineer.getCategory());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				messege = "Engineer Registered Sucessfully...!";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			messege = e.getMessage();
		}
		
		
		
		return messege;
	}



	@Override
	public List<Engineer> getAllEngineerDetails() throws EngineerException {
		
		List<Engineer> eng = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Engineer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int engid = rs.getInt("engid");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String category = rs.getString("category");
				eng.add(new Engineer(engid,name, username, password, category));
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}
		if (eng.size() == 0) {
			throw new EngineerException("No Engineer Found !!!!");
		}
		
		
		return eng;
	}



	@Override
	public String deleteEngineer(int engId) throws EngineerException {
		
		String messege = "Engineer Not Found This System...!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from Engineer where engId= ?");
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				messege = "Engineer Deleted Sucessfully...!";
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			messege = e.getMessage();
		}
		
		
		return messege;
	}



	@Override
	public List<Complain> getAllProblems() throws ComplainException {

		
		List<Complain> com = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Complain");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("ComplainId");
				String name = rs.getString("ComplainName");
				String category = rs.getString("Category");
				
				Complain cp = new Complain(id, name, category);
				com.add(cp);
						
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ComplainException(e.getMessage());
		}
		
		if(com.size() == 0) {
			throw new ComplainException("No Complains Found!");
		}
		
		
		return com;

	}



	@Override
	public String assignedComplain(int engid, String name, String category, int id, String status) {
		
		String message = "Complain Not Assigned... ! ";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into EngineerComplain(engid,name,category,EcomplainId,ComplainStatus) values(?,?,?,?,?)");
			
			ps.setInt(1, engid);
			ps.setString(2, name);
			ps.setString(3, category);
			ps.setInt(4, id);
			ps.setString(5, status);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Complain Assigned To Engineer " +name+ " Sucessfully... !";
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		
	
		return message;
	}

}































