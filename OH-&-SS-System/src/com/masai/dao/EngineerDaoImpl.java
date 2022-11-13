package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EngineerException;
import com.masai.model.Eng_Com;
import com.masai.utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public String loginEngineer(String usersname, String password) throws EngineerException {
		
		String messege = "Invalid Credentials";
		
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Engineer where username = ? AND password = ?");
			
			ps.setString(1, usersname);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString("name");
				messege = "Welcome "+ name;
			}else {
				messege = "Wrong Credentials";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
			
			throw new EngineerException("Engineer Not Found !!!!");
		}
		
		
		
		
		return messege;
		
	}

	@Override
	public List<Eng_Com> ComplainAssignedByHod(int engid) throws ComplainException {

		List<Eng_Com> ec = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from EngineerComplain where engid = ?");
			
			ps.setInt(1, engid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("engid");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int EcomplainId = rs.getInt("EcomplainId");
				String ComplainStatus = rs.getString("ComplainStatus");
				
				ec.add(new Eng_Com(eid, name, category, EcomplainId, ComplainStatus));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ComplainException("Complain Not Assigned...!");
		}
		
		if(ec.size()==0) {
			throw new  ComplainException("No Complain Assigned...!");
		}
		
		
		return ec;
		
		
	}

	@Override
	public String updateStatus(int engId) throws ComplainException {

		String message = "Complain Status Not Updated...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("Update EngineerComplain set ComplainStatus = 'Resolved' where EcomplainId = ?");
			
			ps.setInt(1, engId);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Complain Status Updated Sucessfull... !";
			}
			
		
		} catch (SQLException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
	
		return message;

	}

	@Override
	public List<Eng_Com> AttendedComplain(int engid) throws ComplainException {
		
		List<Eng_Com> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			
		   PreparedStatement ps = conn.prepareStatement("select * from EngineerComplain where engid = ? AND ComplainStatus = 'Resolved'");
		   
		   ps.setInt(1, engid);
		   
		   ResultSet rs = ps.executeQuery();
		   
		   while(rs.next()) {
			   
			   int engId = rs.getInt("engid");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int EcomplainId = rs.getInt("EcomplainId");
				String ComplainStatus = rs.getString("ComplainStatus");
				
				list.add(new Eng_Com(engId, name, category, EcomplainId, ComplainStatus));
			   
			   
		   }
		   
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw new ComplainException("No Complain Found...!");
		}
	
		
		return list;
		
	}

	@Override
	public String changePassword(String password, int engid) throws EngineerException {


		String message = "Password Not Changed...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Update Engineer set password = ? where engid = ?");
			
			ps.setString(1, password);
			ps.setInt(2, engid);
			
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
