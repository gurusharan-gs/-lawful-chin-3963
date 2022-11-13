package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.MyException;
import com.masai.model.Engineer;

public class RegisterEngineerUseCase_ {
	
	public static void main(String[] args)throws EngineerException, EmployeeException, MyException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Engineer Name : ");
		String name = sc.next();
		
		System.out.println("Enter the Engineer Username : ");
		String username  = sc.next();
		
		System.out.println("Enter the Engineer Password : ");
		String password  = sc.next();
		
		System.out.println("Enter the Engineer Category (Hardware/Software) : ");
		String category  = sc.next();
		
		
		HODRollsDao hd = new HODRollsDaoImpl();
		
	    Engineer eng = new Engineer();
	    eng.setName(name);
	    eng.setUsername(username);
	    eng.setPassword(password);
	    eng.setCategory(category);
	    
	    try {
	    	
	    	String res = hd.registerEngineer(eng);
		    System.out.println(res);
	        HODDriver.main(args);
		} catch (EngineerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    
			
	}

}
