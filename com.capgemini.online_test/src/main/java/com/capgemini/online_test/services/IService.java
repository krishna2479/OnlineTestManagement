package com.capgemini.online_test.services;

import java.math.BigInteger;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Test;
import com.capgemini.online_test.exception.DurationException;

public interface IService {

public Question addQuestion(Question question);
	
	public Question showQuestion(BigInteger qId);

	public Question updateQuestion(BigInteger id, Question question, String updateType);
	
    public Test addTest(Test test) throws DurationException, DurationException;
	
	public Test updateTest(BigInteger testId, Test test, String updateType);
	
    public Test deleteTest(BigInteger testId);
	
    public Test showTest(BigInteger id);
	
}
