package com.capgemini.online_test.services;

import java.math.BigInteger;
import java.util.Scanner;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Test;
import com.capgemini.online_test.dao.QuestionDaoImpl;
import com.capgemini.online_test.dao.TestDaoImpl;
import com.capgemini.online_test.exception.DurationException;
import com.capgemini.online_test.util.QuestionCollection;

public class ServiceImpl implements IService {

Scanner s = new Scanner(System.in);
	
	QuestionDaoImpl queDao = new QuestionDaoImpl();
	
	@Override
	public Question addQuestion(Question createQue) {
		// TODO Auto-generated method stub
		
		//System.out.println(queDao.addQuestion(createQue));
		
		return queDao.addQuestion(createQue);
	
	}
	
	public Question showQuestion(BigInteger qId)
	{
		
		return queDao.showQuestion(qId);
	}
	
	public Question updateQuestion(BigInteger qId, Question newQuestion, String updateType)
	{

		return queDao.updateQuestion(qId, newQuestion, updateType);
		
	}
	
	QuestionCollection coll = new QuestionCollection();
	TestDaoImpl tDao = new TestDaoImpl();
	
	Question question;
	
	@Override
	public Test addTest(Test test) throws DurationException {
		// TODO Auto-generated method stub
	    
		if(test.getTestDuration().getHour() < 2)
		{
			throw new DurationException("Test duration should be of 2 or more than 2 hour");
		}
		
	    tDao.addTest(test);
	    
		return test;
	}

	@Override
	public Test updateTest(BigInteger tId, Test testObj, String updateType) {

		tDao.updateTest(tId, testObj, updateType);
		
		return testObj;
	
	}

	@Override
	public Test deleteTest(BigInteger testId) {
		
		return tDao.deleteTest(testId);
	}

    @Override	
	public Test showTest(BigInteger id)
	{
		
		 return tDao.showTest(id);
	}
}
