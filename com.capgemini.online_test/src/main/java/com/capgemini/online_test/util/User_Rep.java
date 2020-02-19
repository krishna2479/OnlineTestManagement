package com.capgemini.online_test.util;
import java.math.BigInteger;
import java.util.*;

import com.capgemini.online_test.dto.*;

public class User_Rep {
static Map<Long, BigInteger> table = new HashMap<Long, BigInteger>();

public Map<Long, BigInteger> gettable() {
	return table;
}

public void setTable(Map<Long, BigInteger> table) 
{
	this.table = table;
}
public User_Rep()
{
	
}
public void putData(Long uid,BigInteger tid)
{
table.put(uid,tid);	
}
}


