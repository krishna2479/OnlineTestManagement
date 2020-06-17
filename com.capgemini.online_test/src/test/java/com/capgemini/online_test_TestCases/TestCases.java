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
  public void test1()
  {  
	  assertEquals("Core Java Test", testService.showTest(BigInteger.valueOf(101)).getTestTitle());
	  System.out.println("Verified Test title\n");
  }
  
  @Test
  public void test2()
  {
	  assertEquals(BigDecimal.valueOf(80), testService.showTest(BigInteger.valueOf(101)).getTestMarksScored());
	  System.out.println("Verified obtained marks\n");
  }
	
  @Test
   public void test3()
  {
 
		
	  assertEquals(LocalTime.of(04, 30), testService.updateTest(BigInteger.valueOf(101), main.testUpdate(), "duration").getTestDuration());
	  System.out.println("Verified updated duration\n");
  }
  
  @Test
  public void test4()
  {
	  
	  
	  assertEquals( "Angular Test", testService.deleteTest(BigInteger.valueOf(104)).getTestTitle());
	  System.out.println("Verified title of deleted test(104)\n");
  }
  
  @Test 
  public void test5() throws DurationException
  { 
	  System.out.println("Add test to verify Test Title");
	  assertEquals("Sprint 1", testService.addTest(main.addTest()).getTestTitle());
	  System.out.println("Verified the title of test recently added");
  }
}
