package com.capgemini.online_test.services;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.capgemini.online_test.dao.AccessTestRepository;
import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.exception.MyException;

public class Examination {
        
        public void addQuestion(Question ques, BigInteger testID) {
                new AccessTestRepository().puttingQuestion(testID, ques);
        }
        
        
        public boolean addTest(Tests test)
        {   //AccesingTestRep is a class in dao package which will access the test repository
                
                new AccessTestRepository().putTest(test);
                return true;
        }
        public boolean updateTest(BigInteger testId,Tests newTest )
        {
                if(new AccessTestRepository().checkTest(testId))
                {
                       return  new AccessTestRepository().updateTest(testId, newTest);
                }
                return false;
        }
        public boolean deleteTest(BigInteger testId)
        {
                if(new AccessTestRepository().checkTest(testId))
                {
                       return new AccessTestRepository().deleteTest(testId);
                }
                return false;
        }
        
        public void addQuestions(Question ques,BigInteger testId)
        {       try {
                if(!new AccessTestRepository().checkTest(testId))
                {
                       throw new MyException("test does not exist");
                       
                }}
        catch(MyException e)
        {
                System.out.println(e.getMessage());
        }
             new AccessTestRepository().puttingQuestion(testId, ques);   
        }
        
        public BigDecimal getResult(Tests testId)
        {
                
                return new AccessTestRepository().retrieveMarks(testId);
        }
        public BigDecimal calculateMarks()
        {
                return new BigDecimal(0);
        }
        
        public void updateQuestion(BigInteger testId, Question ques)
        {
                //call for dao
                try
                {
                        if(new AccessTestRepository().checkingQuestion(testId, ques)==false)
                        {
                                throw new MyException("Test id does not exist");
                        }
                }
                catch(MyException e)
                {
                        System.out.println(e.getMessage());
                }
                new AccessTestRepository().updatingQuestion(testId, ques);
        }
        
        public void deletingQuestion(BigInteger testId,Question ques)
        {
                new AccessTestRepository().deleteQuestion(testId, ques);
        }

}
