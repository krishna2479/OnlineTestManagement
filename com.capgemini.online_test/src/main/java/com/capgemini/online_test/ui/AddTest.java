package com.capgemini.online_test.ui;

import java.math.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;

public class AddTest {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        Tests testobj;
        public AddTest()
        {   System.out.println("enter test id");
                BigInteger testID=sc.nextBigInteger();
                 System.out.println("enter Test Title");
                 String testTitle=sc.next();
                 System.out.println("Enter Test Duration, enter hours then minutes");
                 int hour=sc.nextInt();
                int minute=sc.nextInt();
                LocalTime duration=LocalTime.of(hour, minute);
                BigDecimal totalMarks=sc.nextBigDecimal();
                BigDecimal testMarksScore=sc.nextBigDecimal();
                System.out.println("Enter Start time,yyyy-MM-dd HH:mm ");
                //String str = sc.next();
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime startTime = LocalDateTime.now();//LocalDateTime.parse(str, formatter);
                
                System.out.println("Enter end time,yyyy-MM-dd HH:mm ");
                //str = sc.nextLine();
                
                LocalDateTime endTime = LocalDateTime.now();//parse(str, formatter);
                
                testobj=new Tests(testID,testTitle,duration, null, totalMarks, testMarksScore, null, startTime, endTime);
        }
        public AddTest(BigInteger testId,String title,LocalTime dur,Set<Question> questions,BigDecimal tmarks,BigDecimal marksScored,LocalDateTime sTime,LocalDateTime eTime)
        {
        	testobj= new Tests(testId,title,dur, questions, tmarks, marksScored, null, sTime, eTime);
        }
        public Tests getObject()
        {
                return testobj;
        }
        void pushData()
        {
                new Examination().addTest(testobj);
        }
}
