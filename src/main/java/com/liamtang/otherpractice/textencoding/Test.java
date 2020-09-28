package com.liamtang.otherpractice.textencoding;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Test {
	
	public static void main(String args[]) throws Exception {
		String s3 = "世界您好";
		char[] chs = s3.toCharArray();
		byte[] bs = s3.getBytes("Big5");
		byte[] bs2 = new String(chs).getBytes("UTF-8");

		System.out.println("encoding=" + Charset.defaultCharset().name() + ", " + s3 + " char[].length=" + chs.length
		                + ", byte[].length=" + bs.length + ", byte[]2.length=" + bs2.length);
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(CharBuffer.wrap(chs));
		byte[] b = new byte[bb.remaining()];
		bb.get(b);
		System.out.println(b.length);
	}

}
