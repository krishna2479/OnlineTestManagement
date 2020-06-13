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
	
	
	/*@Test
	public void test() {
		
		com.capgemini.online_test.dto.Question question = main.addTheQuestion();
		
		assertEquals(question.getQuestionTitle() , questionService.addQuestion(question).getQuestionTitle());
		
		assertEquals(question.getQuestionId(), questionService.addQuestion(question).getQuestionId());
	}*/

  @Test
  public void test1()
  {
	  
	  System.out.println("Verifying Test title");
	  
	  
	  
	  assertEquals("Core Java Test", testService.showTest(BigInteger.valueOf(101)).getTestTitle());
	  
	  System.out.println("Verifying obtained marks");
	  assertEquals(BigDecimal.valueOf(80), testService.showTest(BigInteger.valueOf(101)).getTestMarksScored());
	  
  }
	
  @Test
   public void test2()
  {
 
		
	  assertEquals(LocalTime.of(04, 30), testService.updateTest(BigInteger.valueOf(101), main.testUpdataion(), "duration").getTestDuration());
	  System.out.println("Verified updated duration");
  }
  
  @Test
  public void test3()
  {
	  
	  
	  assertEquals( "CSS Test", testService.deleteTest(BigInteger.valueOf(103)).getTestTitle());
	  System.out.println("Verified title of deleted test(103)");
  }
  
  @Test 
  public void test4() throws DurationException
  { 
	  System.out.println("Add test to verify Test Title");
	  assertEquals("java", testService.addTest(main.createTest()).getTestTitle());
	  System.out.println("Verified the title of test recently added");
  }
}
