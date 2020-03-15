	package com.capgemini.online_test.ui;
	import java.math.BigInteger;
	import java.util.*;

	import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;
	public class UpdateQuestion {
		Scanner sc=new Scanner(System.in);
	        UpdateQuestion()
	        {   
	        	
	            System.out.println("enter test id");
	                BigInteger QuestionId=sc.nextBigInteger();
	                System.out.println("Add question details");
	                Question ques=new AddQuestions().getObject();
	                
	        }
	        void takeUpdatedQuestion()
	        {   
	                //call for examination
	        	System.out.println("give the Question Id you want to update");
	             BigInteger questionId=sc.nextBigInteger();
	           //  new Examination().updateTest(questionId, newQuestion);
	                
	        }

	}

 