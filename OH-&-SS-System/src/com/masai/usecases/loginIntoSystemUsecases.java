package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.HodException;

public class loginIntoSystemUsecases {
	
	public static void main(String[] args)throws HodException  {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the UserName");
		String username = sc.next();
		
		System.out.println("Enter the Password");
		String password = sc.next();
		
		
		HODRollsDao hd = new HODRollsDaoImpl();
		
		
		try {
			
			String res = hd.loginIntoSystem(username, password);
			System.out.println(res);
		 //  ------------
		} catch (HodException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}
