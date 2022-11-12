package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;
import com.mysql.cj.jdbc.Driver;

public class RegisterEmployeeUseCase2 {
	
	public static void main(String[] args)throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name : ");
		String name  = sc.next();
		
		System.out.println("Enter Employee Username : ");
		String username  = sc.next();
		
		System.out.println("Enter Employee Password : ");
		String password  = sc.next();
		
		
		EmployeeDao empdao = new EmployeeDaoImpl();
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setName(username);
		emp.setName(password);
		
		String res = empdao.registerEmployee2(emp);
		
		System.out.println(res);
		
//		try {
//			
//			Driver.main(args);
//			
//		} catch (EmployeeException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
	}

}
