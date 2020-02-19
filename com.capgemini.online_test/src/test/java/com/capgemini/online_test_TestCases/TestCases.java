package com.capgemini.online_test_TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.ui.AddingQuestions;
import com.capgemini.online_test.ui.AddingTest;
public class TestCases {
	@Test
    public void getResultTest()
    {
		/*Question q1=new AddingQuestions(new BigInteger("111"),"ques1",new ArrayList<String>(),new Integer(1),new BigDecimal(4),new Integer(2),new BigDecimal(0)).getObject();
		Question q2=new AddingQuestions(new BigInteger("112"),"ques1",new ArrayList<String>(),new Integer(2),new BigDecimal(4),new Integer(2),new BigDecimal(0)).getObject();
		Question q3=new AddingQuestions(new BigInteger("113"),"ques1",new ArrayList<String>(),new Integer(3),new BigDecimal(4),new Integer(3),new BigDecimal(0)).getObject();
		Question q4=new AddingQuestions(new BigInteger("114"),"ques1",new ArrayList<String>(),new Integer(4),new BigDecimal(4),new Integer(4),new BigDecimal(0)).getObject();
		Question q5=new AddingQuestions(new BigInteger("115"),"ques1",new ArrayList<String>(),new Integer(1),new BigDecimal(4),new Integer(4),new BigDecimal(0)).getObject();
		Question q6=new AddingQuestions(new BigInteger("116"),"ques1",new ArrayList<String>(),new Integer(2),new BigDecimal(4),new Integer(2),new BigDecimal(0)).getObject();
        Set<Question> questions=new TreeSet<Question>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);*/
        Tests test=new AddingTest(new BigInteger("10001"),"test1",LocalTime.of(3,0),new TreeSet<Question>(),new BigDecimal(24),new BigDecimal(0),LocalDateTime.parse("2020-02-19 09:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),LocalDateTime.parse("2020-02-19 12:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).getObject();
        assertEquals(true,new Examination().addTest(test));
    }
}
