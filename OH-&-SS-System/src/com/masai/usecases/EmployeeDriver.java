package com.masai.usecases;

import java.util.Scanner;

import com.masai.Driver.Driver;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;

public class EmployeeDriver {
	
	public static void main(String[] args)throws EmployeeException, MyException,EngineerException, HodException, ComplainException {
		
		while (true) {
			
			System.out.println("1. Register Complaint");
            System.out.println("2. Check Status of Complaint");
			System.out.println("3. See All Complaints");
            System.out.println("4. Update Password");
			System.out.println("5. Exit To Main Page");
			System.out.println("Please select an option to continue");
			
			
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 :
				RegisterComplainUsecase.main(args);
				break;
			case 2 :
				ComplainStatusCheckUsecase.main(args);
				break;
			case 3 :
				CompletedComplaintHistoryUsecase.main(args);
				break;
			case 4 :
				EmployeeUpdatePassword.main(args);
				break;
			case 5 :
				
				try {
					
					Driver.main(args);
					
				} catch (EmployeeException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
			
		}
		
	}

}
