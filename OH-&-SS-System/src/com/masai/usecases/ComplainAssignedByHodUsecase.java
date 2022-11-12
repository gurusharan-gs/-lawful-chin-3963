package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.model.Eng_Com;

public class ComplainAssignedByHodUsecase {
	
	public static void main(String[] args) throws  ComplainException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer Id : ");
		int n = sc.nextInt();
		
		EngineerDao ed = new EngineerDaoImpl();
		
		try {
			List<Eng_Com> list = ed.ComplainAssignedByHod(n);
			list.forEach(s -> System.out.println(s));
		} catch (ComplainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
