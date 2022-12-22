package com.masai.Driver;

import java.util.Scanner;

import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;
import com.masai.usecases.LoginEmployeeUseCase;
import com.masai.usecases.LoginEngineerUseCase;
import com.masai.usecases.RegisterEmployeeUseCase1;
import com.masai.usecases.RegisterEmployeeUseCase2;
import com.masai.usecases.loginIntoSystemUsecases;

public class Driver {
	
	public static void main(String[] args)throws EmployeeException, MyException, EngineerException, HodException, ComplainException {
		
		System.out.println("Welcome to Online Hardware and Software Support System");
		System.out.println("1. Login as HOD");
		System.out.println("2. Login as Engineer");
		System.out.println("3. Register as Employee");
		System.out.println("4. Login as Employee");
		
		System.out.println();
		
		
		Scanner sc = new Scanner(System.in);
		
		int res = sc.nextInt();
		
		if(res == 1) {
			loginIntoSystemUsecases.main(args);
		}else if(res == 2) {
			LoginEngineerUseCase.main(args);
		}else if(res == 3) {
			RegisterEmployeeUseCase2.main(args);	
		}else if(res == 4) {
			LoginEmployeeUseCase.main(args);
		}else {
			throw new MyException("Invalid Input Please Try Again...");
		}
		
		
	}

}
