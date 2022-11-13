package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;

public class LoginEmployeeUseCase {
	
	public static void main(String[] args)throws EmployeeException, MyException, HodException, ComplainException, EngineerException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Username :");
		String username = sc.next();
		
		System.out.println("Enter Your Password :");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String res = dao.loginEmployee(username, password);
			System.out.println(res);
			EmployeeDriver.main(args);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
