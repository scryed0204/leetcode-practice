package com.liamtang.leetcodepractice;

public class RomanToInteger {
	
	private static String[] romanArray = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static int[] numberArray =   new    int[] {1000,  900, 500,  400, 100,  90,   50,   40,  10,    9,   5,    4,   1};
	
    public int romanToInt(String s) {
    	if (null == s || s.length() == 0) {
    		return 0;
    	}
    	
    	int result = 0;
        String st = s.trim();
        
        int idx = 0;
        
        while (st.length() != 0) {
        	if (st.startsWith(romanArray[idx])) {
        		result += numberArray[idx];
        		st = st.substring(romanArray[idx].length());
        	} else {
        		idx ++;
        		
        		if (idx == romanArray.length) {
        			return 0;
        		}
        	}
        }        
        
        return result;
    }
    
    public static void main(String args[]) {
    	RomanToInteger o = new RomanToInteger();
    	System.out.println(o.romanToInt("FUCK"));
    	
    }

}
