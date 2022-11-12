package com.masai.usecases;

import java.util.ArrayList;
import java.util.List;

import com.masai.dao.HODRollsDaoImpl;
import com.masai.model.Engineer;

public class getAllEngDetailsUsecase {
	
	public static void main(String[] args) {
		
		HODRollsDaoImpl hd = new HODRollsDaoImpl();
		
		try {
			
			List<Engineer> eng = hd.getAllEngineerDetails();
			eng.forEach(s -> {
				System.out.println("-----------------------------------------");
				
				System.out.println("Engineer ID : "+s.getEngid());
				System.out.println("Engineer Name : "+ s.getUsername());
				System.out.println("Engineer Username : "+ s.getUsername());
				System.out.println("Engineer Password : "+ s.getPassword());
				System.out.println("Engineer Category : "+ s.getCategory());
				
				System.out.println("-----------------------------------------");
				
				
			});
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
