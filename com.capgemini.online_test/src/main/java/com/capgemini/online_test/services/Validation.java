package com.capgemini.online_test.services;

public class Validation {

	public static String userIdPattern="[1-9][0-9][0-9][0-9]";
	public static String testId="[1-9][0-9][1-9]";
	String questionId = "[0-9][0-9][1-9]";
	
	public static boolean validatedata(String data,String pattern)
	{
		return data.matches(pattern);
	}

}
