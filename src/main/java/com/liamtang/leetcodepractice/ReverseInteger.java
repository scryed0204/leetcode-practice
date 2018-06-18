package com.liamtang.leetcodepractice;

public class ReverseInteger {
	public int reverse(int x) {

		int result = 0;

		// Bad Solution Start
		// String val = String.valueOf(Math.abs(x));
		// StringBuilder reverseVal = new StringBuilder();
		// if (x < 0) {
		// reverseVal.append("-");
		// }
		// for (int i = val.length() -1; i >= 0; i-- ) {
		// reverseVal.append(val.charAt(i));
		// }
		// try {
		// result = Integer.parseInt(reverseVal.toString());
		// } catch (NumberFormatException e) {
		// result = 0;
		// }
		// Bad Solution End

		while (x != 0) {
			int pop = x % 10;
			int maxIntComparator = Integer.MAX_VALUE / 10;
			int minIntComparator = Integer.MIN_VALUE / 10;
			if (result > maxIntComparator || (result == maxIntComparator && pop > 7))
				return 0;
			if (result < minIntComparator || (result == minIntComparator && pop < -8))
				return 0;

			result = result * 10 + pop;

			x /= 10;
		}

		return result;
	}

	public static void main(String args[]) {
		// int i = -123;
		// int i = 2147483647;
		// int i = -2147483648;
		int i = -1222222212;
		ReverseInteger o = new ReverseInteger();
		System.out.println(o.reverse(i));
	}

}
