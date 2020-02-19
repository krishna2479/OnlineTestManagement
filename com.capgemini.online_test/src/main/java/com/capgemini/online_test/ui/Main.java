package com.capgemini.online_test.ui;

import java.util.Scanner;

import com.capgemini.online_test.dao.AccessingTestRep;
import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub        
		new AccessingTestRep();
		int choice=0;
        Scanner sc=new Scanner(System.in);
        
        choice=sc.nextInt();
        
        
        System.out.println("Welcome Admin, Choose a path \n");
        System.out.println("1.TESTS");
        System.out.println("2.QUESTIONS");
        System.out.println("3.MARKS");
        switch(choice){
                case 1:System.out.println("SELECT ACTION \n");
                                System.out.println("1. Add Test");
                                System.out.println("2. Update Test");
                                System.out.println("3. Delete Test");
                                System.out.println("4. Assign Test");
                        
                                choice=sc.nextInt();
                                switch(choice){
                                        case 1: new AddingTest().pushData();	 
                                                        break;
                                        case 2: new UpdateTest().takeUpdatedTest();
                                                 break;
                                        case 3: 
                                        		System.out.print("Enter Test id to be deleted");
                                        	    new Examination().deleteTest(new Scanner(System.in).nextBigInteger());
                                                        break;
                                        case 4: 
                                        		//new Examination().
                                        	//assignTest();
                                                        break;
                                        
                                }
                                
                                break;
                case 2:System.out.println("SELECT ACTION \n");
                                System.out.println("1. Add Question");
                                System.out.println("2. Update Question");
                                System.out.println("3. Delete Question");
                                choice=sc.nextInt();

                                        switch(choice){
                                        case 1: new AddingQuestions().pushData();
                                                        break;
                                        case 2: 
                                        		new UpdateQuestion().takeUpdatedQuestion();
                                                        break;
                                        case 3: 
                                        		new Examination().deletingQuestion(new Scanner(System.in).nextBigInteger(),new AddingQuestions().getObject());                                                     
                                        		break;
                                        		
                                }
                                                        break;
                case 3:System.out.println("SELECT ACTION \n");
                                System.out.println("1. Get Result");
                                System.out.println("2. Calculate Total Marks");
                                choice=sc.nextInt();
                                switch(choice){
                                        case 1: new GetResult().pushData();
                                                        break;
                                        case 2: //calculateTotalMarks();
                                                        break;
                                        
                                        
                                }
                                break;
                                
        }
}
}