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
	
	/****************************************************************
	 * Method - addTest
	 * description - add the new object of class Test
	 * @param testId - Test's id
	 * @return - object of class Test
	 * @author - Krishna Kant
	 * created date - 10-FEB-2020
	 ******************************************************************/
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

	
	/****************************************************************
	 * Method - updateTest
	 * description - update the object of class Test with reference of testId
	 *               and save the updated object in variable updatedTest
	 * @param testId - Test's id
	 * @param updatedTest - new object to store updated values
	 * @return - updated object of class Test
	 * @author - Krishna Kant
	 * created date - 11-FEB-2020
	 ******************************************************************/
	@Override
	public Test updateTest(BigInteger tId, Test testObj, String updateType) {
		
		testdao.updateTest(tId, testObj, updateType);
		System.out.println("Test updated successfully.");
		
		return testObj;
	
	}

	
	/****************************************************************
	 * Method - deleteTest
	 * description - delete the object of class Test by testId
	 * @param testId - Test's id
	 * @return - message test deleted or not
	 * @author - Krishna Kant
	 * created date - 12-FEB-2020
	 ******************************************************************/
	@Override
	public Test deleteTest(BigInteger testId) {
		
		return testdao.deleteTest(testId);
	}

	
	/****************************************************************
	 * Method - showTest
	 * description - show the data from the static database
	 * @return - all the object of class Test
	 * @author - Krishna Kant
	 * created date - 13-FEB-2020
	 ******************************************************************/
    @Override	
	public Test showTest(BigInteger id)
	{
		
		 return testdao.showTest(id);
	}
    @Override	
   	public Test deleteTest1(BigInteger id)
   	{
   		
  		 return testdao.deleteTest1(id);
   	}
   
}
