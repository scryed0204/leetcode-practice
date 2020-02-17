package com.liamtang.leetcodepractice;

public class MyAtoi {
	public int parseString(String str) {
		char zero = '0';
		str = str.trim();
		if (null == str || "".equals(str)) {
			return 0;
		}
		int multiplier = 1;
		char curr = str.charAt(0);
		int currentNum = curr - zero;
		if (currentNum < 0 || currentNum > 9) {
			if ('+' == curr) {
				multiplier = 1;
				str = str.substring(1);
			} else if ('-' == curr) {
				multiplier = -1;
				str = str.substring(1);
			} else {
				return 0;
			}
		}

		long result = 0;
		for (int i = 0; i < str.length(); i++) {
			curr = str.charAt(i);
			currentNum = curr - zero;
            if (currentNum < 0 || currentNum > 9) {
				return (int) result;
			} else {
				currentNum = currentNum * multiplier;
				result = result * 10 + currentNum;
				if (result > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if (result < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
				System.out.println(result);

			}
		}

		return (int) result;

	}

	public static void main(String args[]) {
		char[] arr = { '1', '9', 'k', '我' };
		int i = 0;
		for (; i < arr.length; i++) {
			int ascii = (int) arr[i];
//			System.out.println(ascii);
			int digit = arr[i] - '0';
			System.out.println(digit);
		}
//		int k = 2147483647;
//		long l = 2147483647;
//		System.out.println(k);
//		System.out.println(Integer.toString(k, 2));
//		System.out.println(Integer.toString(k, 2).length());
//		System.out.println("----------------------------");
//		for (int i = 0; i <= 10 ;i++) {
//			k += 1;
//			l += 1;
//			System.out.println(k);
//			System.out.println(Integer.toString(k, 2));
//			System.out.println(Integer.toString(k, 2).length());
//			System.out.println("**********************");
//			System.out.println(l);
//			System.out.println(Long.toString(l, 2));
//			System.out.println(l >>> 31);
//			System.out.println(Long.toString(l >>> 31, 2));
//			System.out.println(l >>> 32);
//			System.out.println(Long.toString(l >>> 32, 2));
//			System.out.println("----------------------------");
//		}
	}

}
