package com.masai.usecases;

import java.util.Scanner;

import com.masai.Driver.Driver;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;
import com.masai.model.Employee;


public class RegisterEmployeeUseCase2 {
	
	public static void main(String[] args)throws EmployeeException, MyException, HodException, EngineerException, ComplainException {
		
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
		emp.setUsername(username);
		emp.setPassword(password);
		
		String res = empdao.registerEmployee2(emp);
		
		System.out.println(res);
		
		try {
			
			Driver.main(args);
			
		} catch (EmployeeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
