package com.liamtang.otherpractice.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TestHashMapConcurrency {

	static HashMap<String, String> hm = new HashMap<String, String>();
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
		Iterator<Entry<String, String>> it = hm.entrySet().iterator();
        while(it.hasNext()){
        	Entry<String, String> entry = (Entry<String, String>)it.next();
            System.out.println("Value of "+entry.getKey()+" is: "+entry.getValue());
            
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }

	}

}
