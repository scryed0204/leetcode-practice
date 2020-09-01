package com.liamtang.otherpractice;

public class DivideAndConquer {
	
	private static int f(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n*f(n-1);
		}
	}
	
	public static void main(String args[]) {
		int n=10;
		System.out.println(f(n));
	}
	
//	public static void main(String args[]) {
//		int x = 10;
//		int result = 1;
//		for (int i = 1; i<=x; i++) {
//			result *=i;
//		}
//		System.out.println(result);
//	}

}
