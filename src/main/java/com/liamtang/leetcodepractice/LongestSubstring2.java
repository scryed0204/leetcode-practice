package com.liamtang.leetcodepractice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring2 {
	
	public static void main(String args[]) {
		String s = "abcabcbb";
//		String s = "bbbbb";
//		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
		
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int result = 0;
    	Set<Character> set = new HashSet<Character>();
    	Character currChar = null;
    	
    	for (int i = 0; i < s.length(); i++) {
    		currChar = s.charAt(i);
    		set.add(currChar);
    		for (int j = i+1; j < s.length(); j++) {
    			currChar = s.charAt(j);
    			if (!set.contains(currChar)) {
    				set.add(currChar);
    			} else {
    				break;
    			}
    		}
    		result = (set.size() > result)? set.size() : result;
    		set.clear();
    	}
    	
    	return result;
        
    }

}
