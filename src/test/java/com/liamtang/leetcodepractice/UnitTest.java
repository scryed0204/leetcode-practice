package com.liamtang.leetcodepractice;

import org.junit.Test;

import junit.framework.Assert;

public class UnitTest {
	
	@Test
	public void testAtoi() {
		MyAtoi tester = new MyAtoi();
//		int result = tester.parseString("-91283472332");
//		Assert.assertEquals(-2147483648, result);
//		
//		result = tester.parseString("words and 987");
//		Assert.assertEquals(0, result);
//		
//		result = tester.parseString("4193 with words");
//		Assert.assertEquals(4193, result);
//		
//		result = tester.parseString("   -42");
//		Assert.assertEquals(-42, result);
//		
//		result = tester.parseString("42");
//		Assert.assertEquals(42, result);
//		
//		int result = tester.parseString("  0000000000012345678");
//		Assert.assertEquals(12345678, result);
		int result = tester.parseString("010");
		Assert.assertEquals(12345678, result);
		
		
		
	}

}
