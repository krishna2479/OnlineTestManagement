package com.capgemini.online_test.util;
import com.capgemini.online_test.dto.*;
import java.util.*;
public class Userid_Rep 
		{
		static HashMap<Long, User> table = new HashMap<Long,User>();

		public HashMap<Long,User> gettable() {
			return table;
		}

		public void setTable(HashMap<Long, User> table) 
		{
			Userid_Rep.table = table;
		}
		public Userid_Rep()
		{
			
		}
		public void putData(User ob)
		{
		table.put(ob.getUserId(),ob);	
		}
		}
