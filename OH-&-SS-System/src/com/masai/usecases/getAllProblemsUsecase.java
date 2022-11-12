package com.masai.usecases;

import java.util.List;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.model.Complain;

public class getAllProblemsUsecase {
	
	public static void main(String[] args)throws ComplainException {
		
		HODRollsDao hd = new HODRollsDaoImpl();
		
		try {
			List<Complain> lc = hd.getAllProblems();
			lc.forEach(s -> System.out.println(s));
		} catch (ComplainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
