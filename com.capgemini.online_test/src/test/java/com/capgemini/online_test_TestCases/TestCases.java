package com.capgemini.online_test_TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import com.capgemini.online_test.exception.DurationException;
import com.capgemini.online_test.services.ServiceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalTime;
import com.capgemini.online_test.ui.OnlineTestMain;

public class TestCases {
	ServiceImpl questionService = new ServiceImpl();
	ServiceImpl testService = new ServiceImpl();
	OnlineTestMain main = new OnlineTestMain();
	
	
	@Test
	void test() {
		
		com.capgemini.online_test.dto.Question question = main.addTheQuestion();
		
		assertEquals(question.getQuestionTitle() , questionService.addQuestion(question).getQuestionTitle());
		
		assertEquals(question.getQuestionId(), questionService.addQuestion(question).getQuestionId());
	}

  @Test
  void test1()
  {
	  
	  System.out.println("Checkin test title");
	  
	  
	  
	  assertEquals("Java Test", testService.showTest(BigInteger.valueOf(101)).getTestTitle());
	  
	  System.out.println("Checking obtained marks");
	  assertEquals(BigDecimal.valueOf(70.20), testService.showTest(BigInteger.valueOf(101)).getTestMarksScored());
	  
  }
	
  @Test
  void test2()
  {
 
		
	  assertEquals(LocalTime.of(04, 30), testService.updateTest(BigInteger.valueOf(101), main.testUpdataion(), "duration").getTestDuration());
	  System.out.println("Check updated time duration");
  }
  
  @Test
  void test3()
  {
	  
	  
	  assertEquals( "CSS Test", testService.deleteTest(BigInteger.valueOf(102)).getTestTitle());
	  System.out.println("Checking title of deleted test");
  }
  
  @Test 
  void test4() throws DurationException
  { 
		
	  assertEquals("java", testService.addTest(main.createTest()).getTestTitle());
	  System.out.println("Checking title of deleted test");
  }
}
