package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class registerEmployeeUsecase1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name : ");
		String name  = sc.next();
		
		System.out.println("Enter Employee Username : ");
		String username  = sc.next();
		
		System.out.println("Enter Employee Password : ");
		String password  = sc.next();
		
		EmployeeDao emp = new EmployeeDaoImpl();
		
		String res = emp.registerEmployee(name, username, password);
		System.out.println(res);
		
		
		
	}

}
