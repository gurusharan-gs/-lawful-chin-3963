package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;

public class UpdatePasswordUseCases {
	
	public static void main(String[] args)throws EmployeeException, MyException, HodException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		  System.out.println("Enter Engineer Id :");
		  int engid = sc.nextInt();
		  System.out.println("Enter New Password :");
		  String password = sc.next();
		  
		  
		  EngineerDao ed = new EngineerDaoImpl();
		  
		  try {
			String res = ed.changePassword(password, engid);
			System.out.println(res);
			
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EngineerDriver.main(args);
		
	}

}
