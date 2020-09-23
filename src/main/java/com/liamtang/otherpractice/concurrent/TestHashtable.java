package com.liamtang.otherpractice.concurrent;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashtable {

	static Hashtable<String, String> hm = new Hashtable<String, String>();
	static int addKey = 1 ;
	static int addValue = 1 ;

	static {
		hm.put("first", "FIRST INSERTED");
		hm.put("second", "SECOND INSERTED");
		hm.put("third", "THIRD INSERTED");
	}

	public static void main(String args[]) {

		Thread updateThread = new Thread(() ->  {
			int i = 0;
			while (i < 10) {
				System.out.println("CC");
				hm.put(String.valueOf(addKey++), String.valueOf(addValue++));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		});
		updateThread.start();
		Enumeration<String> keys = hm.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println("Value of "+key+" is: "+hm.get(key));
            
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }

	}

}
