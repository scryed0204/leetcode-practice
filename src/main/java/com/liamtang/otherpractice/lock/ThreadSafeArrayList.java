package com.liamtang.otherpractice.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeArrayList<E> {
	
	private final Lock lock = new ReentrantLock();
	
	private final List<E> list = new ArrayList<E>();
	
	private static int i = 0;
	
	public void set(E o) {
//		lock.lock();
		
		try {
			i++;
			list.add(o);
			System.out.println("Adding element by thread"+Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String args[]) {
		final ThreadSafeArrayList<String> lockExample = new ThreadSafeArrayList<String>();
		
		Runnable syncThread = new Runnable() {

			@Override
			public void run() {
				while (i < 6) {
					lockExample.set(String.valueOf(i));
					
					try {
						Thread.sleep(100);						
					} catch (Exception e){
						e.printStackTrace();
					}
				}				
			}			
		};
		
		Runnable lockingThread = new Runnable() {

			@Override
			public void run() {
				while(i < 6) {
					lockExample.set(String.valueOf(i));
					try {
						Thread.sleep(100);						
					} catch (Exception e){
						e.printStackTrace();
					}
				}				
			}			
		};
		
		Thread t1 = new Thread(syncThread, "syncThread");
		Thread t2 = new Thread(lockingThread, "lockingThread");
		
		t1.start();
		t2.start();
	}

}
