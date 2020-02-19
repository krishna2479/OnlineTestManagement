package com.capgemini.online_test.ui;

import java.math.BigInteger;

import com.capgemini.online_test.dto.Question;
import com.capgemini.online_test.dto.Tests;
import com.capgemini.online_test.services.Examination;

public class UpdateTest {
        java.util.Scanner sc=new java.util.Scanner(System.in);
    Tests newTest;
    UpdateTest()
    {
            newTest=new AddingTest().getObject();
            
    }
     void takeUpdatedTest()
     {
             System.out.println("give the testid you want to update");
             BigInteger testId=sc.nextBigInteger();
             new Examination().updateTest(testId, newTest);
     }

}
