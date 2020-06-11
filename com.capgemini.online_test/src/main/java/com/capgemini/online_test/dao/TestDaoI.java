package com.capgemini.online_test.dao;

import java.math.BigInteger;

import com.capgemini.online_test.dto.Test;

public interface TestDaoI {
	
public Test addTest(Test test);
	
	public Test updateTest(BigInteger testId, Test test, String updateType);
	
	public Test deleteTest(BigInteger testId);
	
	public Boolean assignTest(Long userId, Test test);

}
