package com.liamtang.leetcodepractice;

import java.util.ArrayList;
import java.util.List;


public class ZigZagConversion {

	public String convert(String s, int numRows) {
		
		if (1 == numRows) {
			return s;
		}
		
		StringBuilder result = new StringBuilder();
		numRows = Math.min(s.length(), numRows);
		
		List<StringBuilder> rowList = new ArrayList<StringBuilder>();
		StringBuilder row;
		for (int i = 1; i <= numRows; i++) {
			row = new StringBuilder();
			rowList.add(row);
		}
		
		int currentRow = 0;
		boolean isGoingDown = true;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			rowList.get(currentRow).append(c);
			if (currentRow == numRows - 1) {
				isGoingDown = false;
			} else if (currentRow == 0) {
				isGoingDown = true;
			}
			if (isGoingDown) {
				currentRow ++;
			} else {
				currentRow --;
			}
		}
		
		for (StringBuilder sb : rowList) {
			result.append(sb.toString());
		}
		
		return result.toString();
	}

	public static void main(String args[]) {
		ZigZagConversion zz = new ZigZagConversion();
//		System.out.println(zz.convert("PAYPALISHIRING", 2));
//		System.out.println(zz.convert("PAYPALISHIRING", 3));
		System.out.println(zz.convert("PAYPALISHIRING", 4));
	}
}
