package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;

public class loginIntoSystemUsecases {
	
	public static void main(String[] args)throws EmployeeException, MyException, EngineerException, ComplainException,  HodException  {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the UserName");
		String username = sc.next();
		
		System.out.println("Enter the Password");
		String password = sc.next();
		
		
		HODRollsDao hd = new HODRollsDaoImpl();
		
		
		try {
			
			String res = hd.loginIntoSystem(username, password);
			System.out.println(res);
		    HODDriver.main(args);
		} catch (HodException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}
