package com.capgemini.online_test.dao;

import com.capgemini.online_test.dto.User;
import com.capgemini.online_test.util.*;
public class PushInitialData {
	PushInitialData()
	{
		User o1=new User("Admin1","admin123",11101,null,true);
		User o2=new User("user1","user123",21101,null,false);
		User o3=new User("user2","user123",21102,null,false);
		User o4=new User("user3","user123",21103,null,false);
		
		Userid_Rep uidr=new Userid_Rep();
		uidr.putData(o1);
		uidr.putData(o2);
		uidr.putData(o3);
		uidr.putData(o4);
		
		
	}

}
