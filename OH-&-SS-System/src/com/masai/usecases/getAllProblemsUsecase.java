package com.masai.usecases;

import java.util.List;

import com.masai.dao.HODRollsDao;
import com.masai.dao.HODRollsDaoImpl;
import com.masai.exceptions.ComplainException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.EngineerException;
import com.masai.exceptions.MyException;
import com.masai.model.Complain;

public class getAllProblemsUsecase {
	
	public static void main(String[] args)throws EmployeeException, MyException, EngineerException, ComplainException {
		
		HODRollsDao hd = new HODRollsDaoImpl();
		
		try {
			List<Complain> lc = hd.getAllProblems();
			lc.forEach(s -> System.out.println(s));
		} catch (ComplainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HODDriver.main(args);
	}

}
