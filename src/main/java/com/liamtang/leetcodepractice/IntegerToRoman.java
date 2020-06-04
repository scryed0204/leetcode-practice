package com.liamtang.leetcodepractice;

public class IntegerToRoman {
	private static String[] romanArray = new String[] {"M",  "D",  "C", "L", "X", "V", "I"};
	private static int[] numberArray =      new int[] {1000, 500,  100,  50,  10,   5,  1};

	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		
		if (num < 1 || num > 3999) {
			return num + " is not in guaranteed range!";
		}
		
		int idx = 0;
		while (0 != num) {
			num = appendRomanChar(result, idx, num);
			idx += 2;
		}

		return result.toString();

	}
	
	private int appendRomanChar(StringBuilder result, int romanIndex, int num) {
		int remained = 0;
		
		if (0 == romanIndex) {
			int i = num/numberArray[romanIndex];
			remained = num%numberArray[romanIndex];
			
			for(int x=1;x<=i;x++) {
				result.append(romanArray[romanIndex]);
			}			
		} else {
			int i = num/numberArray[romanIndex];
			remained = num%numberArray[romanIndex];
			
			if (i > 0 && i <= 3) {
				while (i != 0) {
					result.append(romanArray[romanIndex]); //C
					i--;
				}
			} else if (i == 4) {
				result.append(romanArray[romanIndex]).append(romanArray[romanIndex-1]); //CD
			} else if (i == 5) {
				result.append(romanArray[romanIndex-1]); //D
			} else if (i > 5 && i < 9) {
				result.append(romanArray[romanIndex-1]); //D
				for(int x=1;x<=i-5;x++) {
					result.append(romanArray[romanIndex]); //C
				}
				while (i != 5) {
					result.append(romanArray[romanIndex]); //C
					i--;
				}
			} else if (i == 9) {
				result.append(romanArray[romanIndex]).append(romanArray[romanIndex-2]); //CM
			}
		}		
		
		return remained;		
	}

//	private void calculateRomanChar(int romanIndex, int currentNum, StringBuilder currentResult) {
//    	if (currentNum/numberArray[romanIndex] < 0) {
//    		if ()
//    	} 
//    	
//    }
	
	public static void main(String args[]) {
		IntegerToRoman o = new IntegerToRoman();
		System.out.println(o.intToRoman(1996));
		System.out.println(o.intToRoman(3));
	}

}
