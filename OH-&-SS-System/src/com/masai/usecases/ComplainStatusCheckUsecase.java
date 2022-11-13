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
import com.masai.model.Eng_Com;

public class ComplainStatusCheckUsecase {
	
	public static void main(String[] args)throws EmployeeException,MyException,EngineerException,HodException {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Complain Id :");
		 int name = sc.nextInt();
		 
		 EmployeeDao dao = new EmployeeDaoImpl();
		 try {
			List<Eng_Com> ec = dao.ComplainStatus(name);
		    ec.forEach(s -> System.out.println(s));
		    EmployeeDriver.main(null);
		} catch (ComplainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
