package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;

public class EmployeeUpdatePassword {
	
	public static void main(String[] args)throws EmployeeException, MyException, EngineerException, HodException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id :");
		  int empid = sc.nextInt();
		  System.out.println("Enter New Password :");
		  String password = sc.next();
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		String res;
		try {
			 res = ed.changePassword(password, empid);
			System.out.println(res);
			EmployeeDriver.main(args);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
