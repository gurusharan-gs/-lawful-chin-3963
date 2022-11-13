package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;

public class updateComplainStatusUsecase {
	
  public static void main(String[] args)throws EmployeeException, MyException, HodException, ComplainException {
	
	  
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("Enter Engineer Id To Update Problem Status :");
		 int num = sc.nextInt();
		 
		 EngineerDao ed = new EngineerDaoImpl();
		 
		 String res = ed.updateStatus(num);
		 
		 System.out.println(res);
		 
		 EngineerDriver.main(args);
		 
	  
	  
}

}
