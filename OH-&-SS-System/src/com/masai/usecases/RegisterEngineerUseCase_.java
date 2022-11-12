package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.EngineerException;
import com.masai.model.Engineer;

public class RegisterEngineerUseCase_ {
	
	public static void main(String[] args)throws EngineerException {
		
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
	
		} catch (EngineerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    
			
	}

}
