package com.capgemini.online_test.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.online_test.dto.Test;
import com.capgemini.online_test.dto.User;


public class UserCollection {

	static HashMap<Long, User> userMap = new HashMap<Long, User>();
	static Test userTest = new Test();
	
	static
	{
		userMap.put((long) 1001,  new User((long) 1001,  "Krishna",       userTest, true, "krishna@112"));
		userMap.put((long) 1002,  new User((long) 1002,  "Gautam123",     userTest, false, "gautam@123"));
		userMap.put((long) 1003,  new User((long) 1003,  "Jaspreet",      userTest, false, "jaspreet@123"));
		userMap.put((long) 1004,  new User((long) 1004,  "shahil234",     userTest, false, "shahil@234"));
		userMap.put((long) 1005,  new User((long) 1005,  "Ram998",        userTest, false, "ram@998"));
		userMap.put((long) 1006,  new User((long) 1006,  "deepak",        userTest, false, "deepak@1102"));
		userMap.put((long) 1007,  new User((long) 1007,  "krishna123",    userTest, true, "krishna@123"));
		userMap.put((long) 1008,  new User((long) 1008,  "jaspreet121",   userTest, true, "jaspreet@121"));
		userMap.put((long) 1009,  new User((long) 1009,  "Gautam",        userTest, true, "gautam@1102"));
	}
	
	static public void addUser(User u)
	{
		userMap.put(u.getUserId(), u);
	}
	
	public void assignTestToUser(Long id, User user)
	{
		userMap.put(id, user);
	}
	
	public User getUser(long id)
	{
		for(Map.Entry<Long, User> map : userMap.entrySet())
		{
			if(map.getKey() == id)
			  return map.getValue();
		}
		return null;
	}

	
}
