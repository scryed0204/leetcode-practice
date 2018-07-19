package com.liamtang.leetcodepractice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int result = 0;

		// Bad Solution Start
		// List<Character> charList;
		// List<Character> charListTemp = new ArrayList<Character>();
		// for (int i = 0; i < s.length(); i++) {
		// charList = new ArrayList<Character>();
		// String subString = s.substring(i);
		//
		// char[] charArray = subString.toCharArray();
		// for (char c : charArray) {
		// if (charList.contains(c)) {
		// break;
		// }
		// charList.add(c);
		// }
		// if (charList.size() > charListTemp.size()) {
		// charListTemp = charList;
		// }
		// }
		//
		// result = charListTemp.size();
		// System.out.println(charListTemp.toString());
		// Bad Solution End

		int n = s.length();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (isUnique(s, i, j)) {
					result = Math.max(result, j - i);
				}
			}
		}

		return result;
	}

	private boolean isUnique(String s, int start, int end) {

		Set<Character> set = new HashSet<Character>();

		for (int i = start; i < end; i++) {
			Character c = s.charAt(i);
			if (set.contains(c)) {
				return false;				
			}
			set.add(c);
		}

		return true;
	}

	public static void main(String args[]) {
		System.out.println("Please input a String: ");
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		LongestSubstring o = new LongestSubstring();

		try {
			System.out.println(o.lengthOfLongestSubstring(inputString));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

}
