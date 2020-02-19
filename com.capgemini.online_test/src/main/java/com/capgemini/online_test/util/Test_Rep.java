package com.capgemini.online_test.util;

import com.capgemini.online_test.dto.Tests;
import java.math.BigInteger;
import java.util.*;
public class Test_Rep {
        static HashMap<BigInteger, Tests> table = new HashMap<BigInteger,Tests>();

        public HashMap<BigInteger,Tests> gettable() 
        {
                return table;
        }

        public void setTable(HashMap<BigInteger, Tests> table) 
        {
                Test_Rep.table = table;
        }
      
        public void putData(Tests ob)
        {
        table.put(ob.getTestId(),ob); 
        
        }
        public void putData(BigInteger testId,Tests ob)
        {
                table.put(testId,ob);
        }
        public void removeData(BigInteger testId)
        {
                table.remove(testId);
        }
        }
