package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.MyException;

public class deleteEngineerUsecase {
	
	public static void main(String[] args)throws EmployeeException, MyException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter Engineer Id And Delete :");
		 int eid = sc.nextInt();
		 
		 HODRollsDao hd = new HODRollsDaoImpl();
		 
		 try {
			
			 String d = hd.deleteEngineer(eid);
			 System.out.println(d);
			 HODDriver.main(args);
		} catch (EngineerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
