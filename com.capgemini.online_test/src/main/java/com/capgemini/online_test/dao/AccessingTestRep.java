
package com.capgemini.online_test.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.util.Test_Rep;

public class AccessingTestRep {
        
        
        
        public boolean putTest(Tests test)
        {
                new Test_Rep().putData(test);
                return true;
        }
        public void updateTest(BigInteger testid,Tests test)
        {
                new Test_Rep().putData(testid, test);
        }
        public boolean checkTest(BigInteger testId)
        {
                HashMap<BigInteger,Tests> tr=new Test_Rep().gettable();
                return tr.containsKey(testId);
                
        }
        public void deleteTest(BigInteger testId)
        {
                new Test_Rep().removeData(testId);
        }
        public BigDecimal retrieveMarks(Tests testId)
        {
                HashMap<BigInteger,Tests> tr=new Test_Rep().gettable();
                Set<Question> quesSet=tr.get(testId).getTestQuestions();
                Iterator<Question> it=quesSet.iterator();
                BigDecimal sum=new BigDecimal(0);
                while(it.hasNext())
                {
                        sum=sum.add(it.next().getMarksScored());
                }
                return sum;
        }
        
      public  boolean checkingQuestion(BigInteger testId, Question ques)
        {Test_Rep table=new Test_Rep();
                HashMap <BigInteger,Tests> testTable=table.gettable();
                Tests test= testTable.get(testId);
                Set<Question> questions=test.getTestQuestions();
        Iterator<Question> it=questions.iterator();
        BigInteger checkId=ques.getQuestionId();
        while(it.hasNext())
        {
           if(it.next().getQuestionId()==checkId)
           {
                   return true;
           }
        }
        return false;
        }
        public void puttingQuestion(BigInteger testId, Question question){
                    Test_Rep table=new Test_Rep();
                    HashMap <BigInteger,Tests> testTable=table.gettable();
                    Tests test= testTable.get(testId);
                    Set<Question> questions=test.getTestQuestions();
                    questions.add(question);
                    table.putData(test);
            }
        public void updatingQuestion(BigInteger testId,Question ques)
        {
                Test_Rep table=new Test_Rep();
                    HashMap <BigInteger,Tests> testTable=table.gettable();
                    Tests test= testTable.get(testId);
                    Set<Question> questions=test.getTestQuestions();
            Iterator<Question> it=questions.iterator();
            BigInteger checkId=ques.getQuestionId();
            while(it.hasNext())
            {  Question q=it.next();
               if(q.getQuestionId()==checkId)
               {
                       questions.remove(q);
                       questions.add(ques);
               }
            }
            test.setTestQuestions(questions);
            table.putData(test);
            
        }
        public void deleteQuestion(BigInteger testId,Question ques)
        {
                Test_Rep table=new Test_Rep();
                    HashMap <BigInteger,Tests> testTable=table.gettable();
                    Tests test= testTable.get(testId);
                    Set<Question> questions=test.getTestQuestions();
            Iterator<Question> it=questions.iterator();
            BigInteger checkId=ques.getQuestionId();
            while(it.hasNext())
            {  Question q=it.next();
               if(q.getQuestionId()==checkId)
               {
                       questions.remove(q);
               }
            }
            test.setTestQuestions(questions);
            table.putData(test);
        }
        
        public void getTotalMarks(BigInteger testId)
        {
            Test_Rep table=new Test_Rep();
            HashMap <BigInteger,Tests> testTable=table.gettable();
            Tests test= testTable.get(testId);
            Set<Question> questions=test.getTestQuestions();
            Iterator<Question> it=questions.iterator();
            while(it.hasNext())
            {  Question q=it.next();
               if(q.getQuestionAnswer()==q.getChosenAnswer())
               {
            	   q.setMarksScored(q.getQuestionMarks());
               }
               else q.setChosenAnswer(0);
            }
            test.setTestQuestions(questions);
            table.putData(test);
            
        }
    
        	
        }
