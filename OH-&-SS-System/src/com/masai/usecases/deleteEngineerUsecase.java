package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.EngineerException;

public class deleteEngineerUsecase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter Engineer Id And Delete :");
		 int eid = sc.nextInt();
		 
		 HODRollsDao hd = new HODRollsDaoImpl();
		 
		 try {
			
			 String d = hd.deleteEngineer(eid);
			 System.out.println(d);
			 
		} catch (EngineerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
