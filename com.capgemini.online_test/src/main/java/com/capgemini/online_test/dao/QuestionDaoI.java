package com.capgemini.online_test.dao;

import java.math.BigInteger;

import com.capgemini.online_test.dto.Question;


public interface QuestionDaoI {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(BigInteger queId, Question question, String updateType);
	
	public Question deleteQuestion(BigInteger queId, Question question);
	
	public Question showQuestion(BigInteger queId);
}
