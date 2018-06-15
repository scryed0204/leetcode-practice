package com.liamtang.leetcodepractice;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		TwosumSolution sol = new TwosumSolution();
		int[] nums = { 2,7,11,15 };
		int target = 9;
		int[] twosumResult = sol.twosum(nums, target);
		System.out.println(twosumResult[0] + ", " + twosumResult[1]);
	}
}
