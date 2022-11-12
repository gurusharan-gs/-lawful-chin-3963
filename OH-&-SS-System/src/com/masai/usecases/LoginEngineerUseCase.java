package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exceptions.EngineerException;

public class LoginEngineerUseCase {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Username : ");
		String username = sc.next();
		
		System.out.println("Enter Your Password : ");
		String password = sc.next();
		
		
		EngineerDao ed = new EngineerDaoImpl();
		
		
		
		try {
			
			String res = ed.loginEngineer(username, password);
			System.out.println(res);
			
		} catch (EngineerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
