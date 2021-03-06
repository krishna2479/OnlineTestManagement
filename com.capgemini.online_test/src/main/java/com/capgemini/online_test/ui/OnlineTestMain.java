package com.capgemini.online_test.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Test;
import com.capgemini.online_test.dto.User;
import com.capgemini.online_test.exception.DurationException;
import com.capgemini.online_test.services.ServiceImpl;
import com.capgemini.online_test.services.Validation;
import com.capgemini.online_test.util.QuestionCollection;
import com.capgemini.online_test.util.UserCollection;

public class OnlineTestMain {

static UserCollection uCollection = new UserCollection();
	
	static ServiceImpl serviceTest = new ServiceImpl();
	
	static QuestionCollection coll = new QuestionCollection();
	
	static Question question;
	static String updateType;
	
	static Scanner s = new Scanner(System.in);

	
	//method to add a new test 
	public static Test addTest()
	{
		
       Test test = new Test();
		
		System.out.println("Enter testId");
		BigInteger testId = s.nextBigInteger();
		
		boolean val1 =true;
		while(val1) {
	    if(serviceTest.showTest(testId) != null)
	    {
	    	System.out.println("A test with same test id is already present please enter different id");
	    	testId = s.nextBigInteger();
	    }
	    else
	    	val1=false;
		}
		
		val1 = true;
		while(val1)
		{
			String tId = String.valueOf(testId);
			
			boolean valid = Validation.validatedata(tId, Validation.testId);
			
			if(!valid)
			{
				System.out.println("not a valid id\n enter id again");
				testId = s.nextBigInteger();
			}
			else {
				val1 = false;
				test.setTestId(testId);
			}
		}
		
	    System.out.println("Enter testTitle");
	    
	    s.nextLine();
	    String testTitle = s.nextLine();
	    test.setTestTitle(testTitle);
	    
	    System.out.println("Enter testDuration ----\n enter hour");
	    int testHour = s.nextInt();
	    
	    System.out.println("enter minute");
	    int testMinute = s.nextInt();
	   
	    
		LocalTime testDuration =LocalTime.of(testHour, testMinute,00);
		test.setTestDuration(testDuration);
		
		System.out.println("......Enter testQuestions  .....  ");
		
		System.out.println("Enter no of question ");
		
		int numQ = s.nextInt();
		
		Set<Question> testQuestions = new HashSet<Question>();
	
		for(int i=0; i<numQ; i++) {
		  System.out.println("Enter questionId");
		  
		  BigInteger id = s.nextBigInteger();
		 
		   testQuestions.add(coll.showQuestion(id));
	
		}
		
		test.setTestQuestions(testQuestions);
		
		System.out.println("Enter testTotal Marks");
		BigDecimal testTotalMarks = s.nextBigDecimal();
		
		test.setTestTotalMarks(testTotalMarks);
	    
	    for(Question que : testQuestions)
	    {
	    	 question = que;
	    }
	    
		Question currentQuestion = question;
		test.setCurrentQuestion(currentQuestion);
		
		System.out.println("Enter start time ");
		
		System.out.println("enter date");
		int date = s.nextInt();
		
		System.out.println("enter hour");
		int hour = s.nextInt();
		
		System.out.println("enter minute");
		int minute = s.nextInt();
		
	    LocalDateTime startTime = LocalDateTime.of(2020, 02, date, hour, minute); 
		test.setStartTime(startTime);
	    
	    System.out.println("Enter end time ");
	    
		System.out.println("enter date");
		int date1 = s.nextInt();
		
		System.out.println("enter hour");
		int hour1 = s.nextInt();
		
		System.out.println("enter minute");
		int minute1 = s.nextInt();
	    
	    LocalDateTime endTime = LocalDateTime.of(2020, 02, date1, hour1, minute1);
		test.setEndTime(endTime);
		
		return test;
	}
	
	//method to show the test
	public static void showTest(BigInteger testId)
	{
		Test showTest = serviceTest.showTest(testId);
		
	    if(showTest != null)
	    {
	    System.out.println("Test Title \t Test id \t Test Duration \t Total Marks \t Test Start Time \t Test End Time");
	    
	    System.out.println(showTest.getTestTitle()+"\t"+showTest.getTestId()+"\t\t"+showTest.getTestDuration()+"\t"+
	    showTest.getTestTotalMarks()+"\t"+showTest.getStartTime()+"\t"+showTest.getEndTime());
	
	    Set<Question> queSet = showTest.getTestQuestions();

	    if(queSet == null)
	    {
	    	System.out.println("No questions have added to this test");
	    }
	    else
	    {
	  
	 for(Question question : queSet)
	 { 
		int j =0;

		
		System.out.print("Question number ");
		System.out.println(" "+question.getQuestionTitle());
		
		for(String option : question.getQuestionOptions()) {
			
		  System.out.println("Option : "+(j+1)+" "+question.getQuestionOptions().get(j));
		  j++;
		}
		
		System.out.println("\n");
	}
	    }
	    }
	    
	    else
	    	System.out.println("Test not available with this Test Id.");
	}
	
	//method to delete test
	public static void deleteTest(BigInteger testId1)
	{
		
		if(serviceTest.showTest(testId1) != null)
	    {
	    	serviceTest.deleteTest(testId1);
	    	System.out.println("Test deleted.");
	    }else
	    	System.out.println("Test not available");
	}
	    
	
	//method to update the test.
	public static Test testUpdate()
	{
		Test testObj = new Test();
		
		System.out.println("Enter 1 to update test duration");
		System.out.println("Enter 2 to update questions in test");
		
		System.out.println("Enter choice");
		
		String choice = s.next();
		
		switch (choice) {
		case "1":
			System.out.println("Enter new duration \n Enter hour");
			
			int testHour = s.nextInt();
			updateType = "duration";
			
			System.out.println("Enter minute");
			int testMinute = s.nextInt();
			
			testObj.setTestDuration(LocalTime.of(testHour, testMinute, 00));
			
			break;

		case "2":
			System.out.println("Enter no of question ");
			
			int numQ = s.nextInt();
			updateType = "questions";
			
			Set<Question> testQuestions = new HashSet<Question>();
		
			for(int i=0; i<numQ; i++) {
			  System.out.println("Enter questionId");
			  
			  BigInteger id = s.nextBigInteger();
			  
			  testQuestions.add(coll.showQuestion(id));
				  
			  testObj.setTestQuestions(testQuestions);
			}
			
			break;
			
		default :
			System.out.println("no such case available");
		}
		
		return testObj;
	}
	
	
	public static Question addTheQuestion()
	{
		Question createQue = new Question();
        ArrayList<String> option = new ArrayList<String>();
		
		int i=0;
		
		System.out.println("Enter question id");
		BigInteger qId = s.nextBigInteger();
		
		
		System.out.println("Enter question title");
		
		s.nextLine();
		String qTitle = s.nextLine();
		
		System.out.println("Enter question options");
		
		while(i < 4) {
		System.out.println("Enter "+i+"st option");
		
		String opt = s.nextLine();
		
		option.add(opt);
		
		i++;
		}
		
		System.out.println("Enter correct option");
		Integer cOption = s.nextInt();
		
		//System.out.println();
		
		System.out.println("Enter question marks");
		BigDecimal queMark = s.nextBigDecimal();
		
		createQue.setQuestionId(qId);
		createQue.setQuestionTitle(qTitle);
		createQue.setQuestionOptions(option);
		createQue.setQuestionMarks(queMark);
		createQue.setQuestionAnswer(cOption);
		
		return createQue;
	}
	
	public static Question questionUpdation()
	{
        Question newQuestion = new Question();
		
		System.out.println("Enter 1 to change the title of the question");
		System.out.println("Enter 2 to change the marks of the question");
		System.out.println("Enter 3 to change the option");
		System.out.println("Enter the choice");
		
		String choice = s.next();
		
		switch (choice) {
		case "1":
			updateType = "title";
			System.out.println("Enter new title of the question");
			s.nextLine();
			String title = s.nextLine();
			
			newQuestion.setQuestionTitle(title);
		break;

		case "2":
			
			updateType = "marks";
			System.out.println("Enter new mark");
			BigDecimal mark = s.nextBigDecimal();
			
			newQuestion.setQuestionMarks(mark);
		break;
			
		case "3":
			
			updateType = "options";
			
			ArrayList<String> option = new ArrayList<>();
			int i=0;
			
			while(i<4)
			{
				System.out.println("Enter option "+(i+1));
				String opt = s.nextLine();
				option.add(opt);
			}
			
			newQuestion.setQuestionOptions(option);
		break;	
		
		default :
			System.out.println("no such case");
		}
		
		return newQuestion;
	}
	
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub

				
		System.out.println(".......  Welcome to Online Test Management ........");
		System.out.println("Enter user id to use our services");
		
		String id = s.next();
		
		long userId =0;
		
		boolean val = true;
		
		while(val)
		{
			
			boolean valid = Validation.validatedata(id, Validation.userIdPattern);
		
		if(valid == true)
		{
			userId = Long.parseLong(id);
			val = false;
		}
		else
		{
			System.out.println("Not a valid user id \n enter 4 digits only");
			id = s.next();
		}
	}
		
		User currentUser = uCollection.getUser(userId);
		
		if(currentUser != null) {
		if(currentUser.isAdmin())
		{
			System.out.println("You are an admin ");
			
		boolean q = true;
		
		while(q == true)
		{
			
	     System.out.println(" Enter 1 add test\n Enter 2 to show test \n Enter 3 to update the test \n "
	     	+ "Enter 4 to delete the test "+ "\n Enter 5 to add question \n Enter 6 to update the question"
	     				+ "\n Enter 7 to show the test \n Enter other to exit");
	     
	     String choice = s.next();
	     
	     switch(choice)
	     {
	     case "1":
	    	 
	    	 Test test1 = addTest();
			try {
				serviceTest.addTest(test1);
			} catch (DurationException e) {
				
				System.out.println(e.getMessage());
			}
		  
		   break;
		
	     case "2":
	    	 System.out.println("Enter testId");
	 		
	 		BigInteger testId = s.nextBigInteger();
	    	 
		    showTest(testId);
		   
		break;
		
		case "3":
			
			System.out.println("Enter the test id to update the test");
			BigInteger tId = s.nextBigInteger();
			
			Test test2 = testUpdate();
			serviceTest.updateTest(tId, test2, updateType);
			break;
		
		case "4":
			System.out.println("Enter id to delete the test");
			BigInteger testId1 = s.nextBigInteger();
			
			deleteTest(testId1);
			break;
			
		case "5":
			
			Question question1 = addTheQuestion();
			
			serviceTest.addQuestion(question1);
			break;
			
		case "6":
			
			System.out.println("Enter question id to update the question");
			BigInteger queId = s.nextBigInteger();
			
			Question question2 = questionUpdation();
			serviceTest.updateQuestion(queId, question2, updateType);
		break;	
			
		case "7":
			System.out.println("Enter question id");
			
			BigInteger queId1 = s.nextBigInteger();
			
			Question question3 = serviceTest.showQuestion(queId1);
			int j =0;
			
			System.out.print("Question : ");
			System.out.println(" "+question3.getQuestionTitle());
			
			for(String option : question3.getQuestionOptions()) {
				
			  System.out.println("Option : "+(j+1)+" "+question3.getQuestionOptions().get(j));
			  j++;
			}
			break;
		
		default:
			q = false;
			
	     }
		}
		
		}
		else
		{
			System.out.println("you are not an admin");
			
			boolean r = true;
			
			while(r == true)
			{
			  System.out.println("Enter 1 to give the test\n other to exit");
			    int choice = s.nextInt();
			  
			    switch (choice) {
				case 1:
					
					System.out.println("Enter testId");
					
					BigInteger tId = s.nextBigInteger();
					showTest(tId);
					
				break;

				default:
					r= false;
				break;
				}
			    
			}
		}
	
		}
		else
			System.out.println("User doesnt exist");
	}
}
