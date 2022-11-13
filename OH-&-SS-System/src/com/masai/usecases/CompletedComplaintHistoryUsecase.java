package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.HodException;
import com.masai.exceptions.MyException;
import com.masai.model.Complain;

public class CompletedComplaintHistoryUsecase {
	
	public static void main(String[] args)throws MyException, EngineerException, HodException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		  System.out.println("Enter Employee Id :-");
		  int id = sc.nextInt();
		  
		  EmployeeDao ed = new EmployeeDaoImpl();
		  
		  try {
			List<Complain> lcom = ed.getComplainHistory(id);
			lcom.forEach(s -> System.out.println(s));
			EmployeeDriver.main(null);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
