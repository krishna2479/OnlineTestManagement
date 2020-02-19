package com.capgemini.online_test.services;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.capgemini.online_test.dao.AccessingTestRep;
import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.exception.MyException;

public class Examination {
        
        public void addQuestion(Question ques, BigInteger testID) {
                new AccessingTestRep().puttingQuestion(testID, ques);
        }
        
        
        public boolean addTest(Tests test)
        {   //AccesingTestRep is a class in dao package which will access the test repository
                
                new AccessingTestRep().putTest(test);
                return true;
        }
        public void updateTest(BigInteger testId,Tests newTest )
        {
                if(new AccessingTestRep().checkTest(testId))
                {
                        new AccessingTestRep().updateTest(testId, newTest);
                }
        }
        public void deleteTest(BigInteger testId)
        {
                if(new AccessingTestRep().checkTest(testId))
                {
                        new AccessingTestRep().deleteTest(testId);
                }
        }
        
        public void addQuestions(Question ques,BigInteger testId)
        {       try {
                if(!new AccessingTestRep().checkTest(testId))
                {
                       throw new MyException("test does not exist");
                       
                }}
        catch(MyException e)
        {
                System.out.println(e.getMessage());
        }
             new AccessingTestRep().puttingQuestion(testId, ques);   
        }
        
        public BigDecimal getResult(Tests testId)
        {
                
                return new AccessingTestRep().retrieveMarks(testId);
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
                        if(new AccessingTestRep().checkingQuestion(testId, ques)==false)
                        {
                                throw new MyException("Test id does not exist");
                        }
                }
                catch(MyException e)
                {
                        System.out.println(e.getMessage());
                }
                new AccessingTestRep().updatingQuestion(testId, ques);
        }
        
        public void deletingQuestion(BigInteger testId,Question ques)
        {
                new AccessingTestRep().deleteQuestion(testId, ques);
        }

}
