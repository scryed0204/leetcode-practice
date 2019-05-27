package com.liamtang.leetcodepractice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
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
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
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
