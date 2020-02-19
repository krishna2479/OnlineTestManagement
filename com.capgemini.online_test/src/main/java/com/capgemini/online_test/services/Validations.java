package com.capgemini.online_test.services;

import java.math.BigInteger;

import com.capgemini.online_test.exception.AlphabeticException;
import com.capgemini.online_test.exception.PasswordException;

public class Validations {
	public static boolean validUserId(BigInteger userId)
	{
		try
		{
			if(userId != null)
			{
				return true;
			}
			else
			{
				throw new IllegalArgumentException("User id cannot be null");
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean validId(BigInteger testId)
	{
		try
		{
			if(testId != null)
			{
				return true;
			}
			else
			{
				throw new IllegalArgumentException("Test id cannot be null");
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	public static boolean validQuestionId(BigInteger questionId)
	{
		try
		{
			if(questionId != null)
			{
				return true;
			}
			else
			{
				throw new IllegalArgumentException("Question Id cannot be null");
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	public static boolean validUsername(String userName)
	{
		try
		{
			if((userName != null)&&(!userName.equals(""))&&(userName.matches("[A-Z]{1}[a-z]")))
			{
				return true;
			}
			else
			{
				throw new AlphabeticException("username cannot be null and First letter should be capital");
			}
		}
		catch(AlphabeticException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	public static boolean validUserpassword (String userPassword)
	{
		try
		{
			if((userPassword.matches("((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")))
			{
				return true;
			}
			else
			{
				throw new PasswordException("Please provide password in a right format");
			}
		}
		catch(PasswordException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

}
