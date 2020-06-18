package com.liamtang.leetcodepractice.redo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;


public class ZigZagConversionTest {
	
	ZigZagConversion tester = new ZigZagConversion();	
	static HashMap<Integer, String> answer = new HashMap<Integer, String>();
	static String s = "PAYPALISHIRING";
	static {
		answer.put(1, "PAYPALISHIRING");
		answer.put(2, "PYAIHRNAPLSIIG");
		answer.put(3, "PAHNAPLSIIGYIR");
		answer.put(4, "PINALSIGYAHRPI");
		answer.put(5, "PHASIYIRPLIGAN");
	}
	
	@Test
	public void test() {

		for (int i = 1; i <= 5; i++) {
			String actual = tester.convert(s, i);
			System.out.println(actual);
			assertEquals(answer.get(i), actual);
		}
	}

}
