package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.MyException;

public class RegisterComplainUsecase {
	
	public static void main(String[] args)throws EmployeeException, MyException, EngineerException, ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Category (Hardware/Software) : ");
		String com = sc.next();
		System.out.println("Enter Complain Name : ");
		String cname = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		
		try {
			
			String res = dao.registerComplain(cname, cname);
			System.out.println(res);
			HODDriver.main(args);
		} catch (ComplainException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
