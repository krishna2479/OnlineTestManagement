package com.capgemini.online_test_TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.ui.AddQuestions;
import com.capgemini.online_test.ui.AddTest;

public class TestCases {
	@Test
    public void addTest_Test()
    {
        Tests test=new AddTest(new BigInteger("10001"),"test1",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
        assertEquals(true,new Examination().addTest(test));
    }
	@Test
	public void updateTest_Test()
	{   Tests test=new AddTest(new BigInteger("10001"),"test1",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
		Tests test1=new AddTest(new BigInteger("10001"),"newTest",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
		new Examination().addTest(test);
		assertEquals(true,new Examination().updateTest(new BigInteger("10001"), test1));
	}
	@Test
	public void updateTest_Test2()
	{   Tests test=new AddTest(new BigInteger("10001"),"test1",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
		Tests test1=new AddTest(new BigInteger("10001"),"newTest",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
		new Examination().addTest(test);
		assertEquals(false,new Examination().updateTest(new BigInteger("10002"), test1));
	}
	@Test
	public void deleteTest_Test()
	{
		Tests test=new AddTest(new BigInteger("10001"),"test1",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
		new Examination().addTest(test);
		assertEquals(true,new Examination().deleteTest(new BigInteger("10001")));
		
	}
	@Test
	public void deleteTest_Test2()
	{
		Tests test=new AddTest(new BigInteger("10001"),"test1",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
		new Examination().addTest(test);
		assertEquals(false,new Examination().deleteTest(new BigInteger("10002")));
		
	}
	
}
