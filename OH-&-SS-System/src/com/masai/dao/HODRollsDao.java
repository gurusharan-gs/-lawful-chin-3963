package com.masai.dao;

import java.util.List;

import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.model.Complain;
import com.masai.model.Engineer;

public interface HODRollsDao {
	
	public String loginIntoSystem(String username, String password)throws HodException ;
	
	public String registerEngineer(Engineer engineer)throws EngineerException;
	
	public List<Engineer> getAllEngineerDetails()throws EngineerException;
	
	public String deleteEngineer(int engId) throws EngineerException;
	
	public List<Complain> getAllProblems()throws ComplainException;
	
	public String assignedComplain(int engid,String name,String category,int id,String status);

}
