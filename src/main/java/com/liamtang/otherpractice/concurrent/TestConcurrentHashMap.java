package com.liamtang.otherpractice.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
	
	synchronized public void test() {
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
	}

}
