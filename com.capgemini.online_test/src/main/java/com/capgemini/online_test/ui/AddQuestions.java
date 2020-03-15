package com.capgemini.online_test.ui;
import java.util.*;
import java.math.*;
import com.capgemini.online_test.dto.*;
import com.capgemini.online_test.services.Examination;
import com.capgemini.online_test.services.Validations;
public class AddingQuestions {
        Scanner sc=new Scanner(System.in);
        Question ques;
        
        public AddingQuestions()
        {
        	/*System.out.println("Enter username");
        	String n=sc.next();
        	Validations.validUsername(n);*/
                System.out.println("enter question id");
                BigInteger qid=sc.nextBigInteger();
                System.out.println("enter question title");
                String title=sc.nextLine();
                List<String> options=new ArrayList<String>();
                options.add("option1");
                options.add("option2");
                options.add("option3");
                options.add("option4");
                System.out.println("enter question answer");
                Integer answer=sc.nextInt();
                System.out.println("enter maximum marks");
                BigDecimal tmarks=sc.nextBigDecimal();
                System.out.println("enter the correct option");
                Integer option=sc.nextInt();
                BigDecimal marks=new BigDecimal(0);
           ques=new Question(qid,options,title,answer,tmarks,option,marks);
        }
        public AddingQuestions(BigInteger quesId,String title,List<String> list,Integer ans,BigDecimal tmarks,Integer option,BigDecimal marks)
        {
        	ques=new Question(quesId,list,title,ans,tmarks,option,marks);   	
        }
        public Question getObject()
        {
                return ques;
        }
        void pushData()
        {
        	System.out.println("Enter test id");
        	BigInteger testId=sc.nextBigInteger();
        	
        	new Examination().addQuestion(ques,testId);
        }

}
