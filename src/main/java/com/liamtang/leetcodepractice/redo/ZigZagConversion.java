package com.liamtang.leetcodepractice.redo;

import java.util.LinkedList;
import java.util.List;

public class ZigZagConversion {
	
	public String convert(String s, int numRows) {
		StringBuilder result = new StringBuilder();
		
		if (1 == numRows) {
			return s;
		}
		
		List<StringBuilder> sbList = new LinkedList<>();
		for (int i = 0 ; i < numRows ; i++) {
			sbList.add(new StringBuilder());
		}
		
		Character current;
		int currentLoop = 1;
		boolean isReturn = false;
		for (int i = 0; i < s.length(); i++) {
			current = s.charAt(i);
			sbList.get(currentLoop - 1).append(current);
			if (currentLoop == numRows) {
				isReturn = true;
			} 
			
			if (currentLoop == 1) {
				isReturn = false;
			}
			
			if (isReturn) {
				currentLoop--;
			} else {
				currentLoop++;
			}
		}
		
		sbList.forEach(x -> {
			result.append(x);
		});
		
		return result.toString();		
	}

}
