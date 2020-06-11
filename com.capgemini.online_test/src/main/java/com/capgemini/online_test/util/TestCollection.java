package com.capgemini.online_test.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Test;
import com.capgemini.online_test.dao.QuestionDaoImpl;




public class TestCollection {

	static QuestionDaoImpl questionDao = new QuestionDaoImpl();
	
	static ArrayList<Test> testList = new ArrayList<Test>();
	static Set<Question> question1 = new HashSet<Question>();
	static Set<Question> question2 = new HashSet<Question>();
	static Set<Question> question3 = new HashSet<Question>();
	
	static Set<Question> question4 = new HashSet<>();
	
	static Question que = new Question();
	
	Test test = new Test();
	
	static 
	{
		
		//question1.add(queService.showQuestion());
		question1.add(questionDao.showQuestion(BigInteger.valueOf(001)));
		question1.add(questionDao.showQuestion(BigInteger.valueOf(004)));
		
		question2.add(questionDao.showQuestion(BigInteger.valueOf(002)));
		question2.add(questionDao.showQuestion(BigInteger.valueOf(003)));
		
		question3.add(questionDao.showQuestion(BigInteger.valueOf(001)));
		question3.add(questionDao.showQuestion(BigInteger.valueOf(004)));
		
		
		testList.add(new Test(BigInteger.valueOf(101), "Java Test",LocalTime.of(02,30,00),question1, 
				BigDecimal.valueOf(100.00), BigDecimal.valueOf(70.20), que, LocalDateTime.of(2020, 2, 12, 9, 30,00, 0),
				LocalDateTime.of(2020, 2, 13, 12, 00,00, 0)));
		
		testList.add(new Test(BigInteger.valueOf(102), "CSS Test",LocalTime.of(02,00,00),question2, 
				BigDecimal.valueOf(100.00), BigDecimal.valueOf(60.20), que, LocalDateTime.of(2020, 2, 15, 9, 30,00, 0),
				LocalDateTime.of(2020, 2, 15, 02, 30,00, 0)));
		
		testList.add(new Test(BigInteger.valueOf(103), "CSS Test",LocalTime.of(02,00,00),question3, 
				BigDecimal.valueOf(100.00), BigDecimal.valueOf(60.20), que, LocalDateTime.of(2020, 2, 15, 9, 30,00, 0),
				LocalDateTime.of(2020, 2, 15, 02, 30,00, 0)));
		
		testList.add(new Test(BigInteger.valueOf(104), "CSS Test",LocalTime.of(02,00,00),question4, 
				BigDecimal.valueOf(100.00), BigDecimal.valueOf(60.20), que, LocalDateTime.of(2020, 2, 15, 9, 30,00, 0),
				LocalDateTime.of(2020, 2, 15, 02, 30,00, 0)));
		
	}
	
	
	static public Test addTest(Test test) {
		testList.add(test);
		return test;
	}

	static public Test showTest(BigInteger id)
	{
		for(Test test : testList)
		{
			if(test.getTestId().compareTo(id) == 0)
				return test;
		}
		
		return null;
	}
	
	public Test updateTest(BigInteger id, Test test)
	{
		
		int index =0;
		for(int i=0; i<testList.size(); i++)
		{
			if(testList.get(i).getTestId() == id)
			{
				index = i;
				break;
			}
		}
		
			testList.set(index, test);
		
			return test;
	}

	public Test deleteTest(BigInteger id)
	{
		int index =0;
		
		for(int i=0; i<testList.size(); i++) {
		 if(testList.get(i).getTestId().compareTo(id) == 0) 
			 index = i;
		}
		return testList.remove(index);
	}
	
	
}
