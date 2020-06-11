package com.capgemini.online_test.dao;

import java.math.BigInteger;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.util.QuestionCollection;


public class QuestionDaoImpl implements QuestionDaoI{

	QuestionCollection queCollect = new QuestionCollection();
	
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		
		return queCollect.addQuestion(question);
		
	}

	@Override
	public Question updateQuestion(BigInteger queId, Question question, String updateType) {
		// TODO Auto-generated method stub
		
		Question currentQue = queCollect.showQuestion(queId);
		
		
		question.setQuestionId(currentQue.getQuestionId());
		question.setQuestionAnswer(currentQue.getQuestionAnswer());
		
		if(updateType.equals("title"))
		{
			question.setQuestionMarks(currentQue.getQuestionMarks());
			question.setQuestionOptions(currentQue.getQuestionOptions());
		}
		else if(updateType.equals("marks"))
		{
			question.setQuestionTitle(currentQue.getQuestionTitle());
			question.setQuestionOptions(currentQue.getQuestionOptions());
			
		}
		else
		{
			question.setQuestionTitle(currentQue.getQuestionTitle());
			question.setQuestionMarks(currentQue.getQuestionMarks());
		}
	
		return queCollect.updateQuestion(queId, question);
	}

	@Override
	public Question deleteQuestion(BigInteger queId, Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question showQuestion(BigInteger queId) {
		// TODO Auto-generated method stub
		return queCollect.showQuestion(queId);
	}

	
	
}
