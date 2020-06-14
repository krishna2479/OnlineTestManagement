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
	TestDaoImpl testdao = new TestDaoImpl();
	
	
	@Override
	public Question addQuestion(Question createQue) {
		// TODO Auto-generated method stub
		
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
	
	Question question;
	
	@Override
	public Test addTest(Test test) throws DurationException {
		// TODO Auto-generated method stub
	    
		if(test.getTestDuration().getHour() < 2)
		{
			throw new DurationException("Test not added duration must be more than 2 hours");
		}
		else {
	    testdao.addTest(test);
	    System.out.println("Test added.");
		}
		return test;
	}

	@Override
	public Test updateTest(BigInteger tId, Test testObj, String updateType) {
		
		testdao.updateTest(tId, testObj, updateType);
		System.out.println("Test updated successfully.");
		
		return testObj;
	
	}

	@Override
	public Test deleteTest(BigInteger testId) {
		
		return testdao.deleteTest(testId);
	}

    @Override	
	public Test showTest(BigInteger id)
	{
		
		 return testdao.showTest(id);
	}
    @Override	
   	public Test deleteTest1(BigInteger id)
   	{
   		
   		 return testdao.showTest(id);
   	}
}
