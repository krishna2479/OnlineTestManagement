package com.capgemini.online_test.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import com.capgemini.online_test.dto.Question;


public class QuestionCollection {

	static ArrayList<Question> questionList = new ArrayList<Question>();

	static 
	{
		ArrayList<String> option1 = new ArrayList<String>();
		option1.add("Numeric");
		option1.add("Boolean");
		option1.add(" Characters");
		option1.add("Both Numeric & Characters");
		
		ArrayList<String> option2 = new ArrayList<String>();
		option2.add("Integers");
		option2.add("Floating � point numbers");
		option2.add("Both Integers and floating � point numbers");
		option2.add("None of the mentioned");
		
		
		questionList.add(new Question(BigInteger.valueOf(001), option1, "1. what do you mean by core java?", 1, BigDecimal.valueOf(1.5), 1, BigDecimal.valueOf(1.5)));
		questionList.add(new Question(BigInteger.valueOf(002), option2, "2. which is true about Operands in Java?", 1, BigDecimal.valueOf(1.5), 1, BigDecimal.valueOf(1.5)));
		
		questionList.add(new Question(BigInteger.valueOf(003), option1, "1. Which of the following can be operands of arithmetic operators?", 1, BigDecimal.valueOf(1.5), 1, BigDecimal.valueOf(1.5)));
		questionList.add(new Question(BigInteger.valueOf(004), option2, "2. Modulus operator, %, can be applied to which of these?", 1, BigDecimal.valueOf(1.5), 1, BigDecimal.valueOf(1.5)));
		
	}
	
	 public Question showQuestion(BigInteger id)
	{
		for(Question que : questionList)
		{
		if(que.getQuestionId().compareTo(id) == 0)
		  return que;
		}
		return null;
	}
	
	public Question addQuestion(Question que)
	{
		questionList.add(que);
		return que;
	}
	
	public Question updateQuestion(BigInteger id, Question question)
	{
		int index = 0;
		
		for(int i =0; i<questionList.size(); i++)
		{
			if(questionList.get(i).getQuestionId().compareTo(id) == 0)
				index = i;
		}
		
	 questionList.set(index, question);
		
	 return question;
	}

	
}

