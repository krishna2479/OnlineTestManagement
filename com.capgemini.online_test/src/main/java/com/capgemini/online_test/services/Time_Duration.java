package com.capgemini.online_test.services;

public class Time_Duration {
	
 
	     public void testduration()
	     {
	    	 int count = 0;
	          long time=count*100000;
	          System.out.println("time:"+time);
	          for(long i=0;i<time;i++)
	          {
	              long sec=i/1000;
	              long min=sec/60;
	              long hr=min/60;
	              sec=sec%60;
	              String str1="Time:"+hr+"::"+min+"::"+sec;
	              int qcounter = 0;
				int qno=qcounter+1;
	          }
	          
	          System.out.println("time over...");
	     }
	}
