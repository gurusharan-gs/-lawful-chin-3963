package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;
import com.masai.model.Eng_Com;

public class GetCompletedComplaintUseCases {
	
	public static void main(String[] args)throws EmployeeException, MyException, HodException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		  System.out.println("Enter Engineer Id to Get List of All Attended Problem : ");
		  int engid = sc.nextInt();
		  
		  EngineerDao ed = new EngineerDaoImpl();
		  
		  try {
			List<Eng_Com> lec = ed.AttendedComplain(engid);
			lec.forEach(s -> System.out.println(s));
		} catch (ComplainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EngineerDriver.main(args);
	}

}
