package com.capgemini.online_test.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;


public class GetResult
{
	java.util.Scanner sc=new java.util.Scanner(System.in);
	Tests testobj;
	GetResult()
	{   System.out.println("enter test id");
		BigInteger testID=sc.nextBigInteger();
		 System.out.println("enter Test Title");
		 String testTitle=sc.nextLine();
		 System.out.println("Enter Test Duration, enter hours then minutes");
		 int hour=sc.nextInt();
		int minute=sc.nextInt();
		LocalTime duration=LocalTime.of(hour, minute);
		BigDecimal totalMarks=sc.nextBigDecimal();
		BigDecimal testMarksScore=sc.nextBigDecimal();
		System.out.println("Enter Start time,yyyy-MM-dd HH:mm ");
		String str = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime startTime = LocalDateTime.parse(str, formatter);
		
		System.out.println("Enter end time,yyyy-MM-dd HH:mm ");
		str = sc.nextLine();
		
		LocalDateTime endTime = LocalDateTime.parse(str, formatter);
		
		testobj=new Tests(testID,testTitle,duration, null, totalMarks, testMarksScore, null, startTime, endTime);
	}
	
	void pushData()
	{
		new Examination().addTest(testobj);
	}
}
