package com.masai.dao;

import java.util.List;

import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EngineerException;
import com.masai.model.Eng_Com;

public interface EngineerDao {
	
	public String loginEngineer(String usersname, String password)throws EngineerException;
	
	public List<Eng_Com> ComplainAssignedByHod(int engid)throws ComplainException;
	
	public String updateStatus(int engId) throws ComplainException;
	
	public List<Eng_Com> AttendedComplain(int engid)throws ComplainException;
	
	public String changePassword(String password,int engid)throws EngineerException;

}
