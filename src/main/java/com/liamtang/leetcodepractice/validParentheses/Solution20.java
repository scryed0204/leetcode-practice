package com.liamtang.leetcodepractice.validParentheses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution20 {
	   public boolean isValid(String s) {
	        
	        Set<Character> starterSet = new HashSet<Character>();
	        starterSet.add('(');
	        starterSet.add('{');
	        starterSet.add('[');
	        
	        Map<Character, Character> closerMap = new HashMap<Character, Character>();
	        closerMap.put(')', '(');
	        closerMap.put('}', '{');
	        closerMap.put(']', '[');
	        
	        Stack<Character> stack = new Stack<Character>();
	        
//	        Character c;
	        for(Character c : s.toCharArray()) {
//	            c = s.charAt(i);
	            if (starterSet.contains(c)) {
	                stack.push(c);
	            } else if (closerMap.keySet().contains(c)) {
	                if (stack.empty() || 
	                    !stack.pop().equals(closerMap.get(c))) {
	                    return false;
	                }
	            }
	        }
	        
	        if (!stack.empty()) {
	            return false;
	        }
	        
	        return true; 
	    }
	   
	   
	   public static void main(String args[]) {
//		   String s = "(HAHAHAHAHAHA) yeah";
		   String s = "(HAHAHAHAHAHA) {yeah";
		   System.out.println(new Solution20().isValid(s));
		   
		   
	   }
}
