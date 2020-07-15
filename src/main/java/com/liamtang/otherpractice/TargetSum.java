package com.liamtang.otherpractice;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {
	
	
	public int findTargetSum(int[] numbers, int target) {
		int result = 0;
		int augendIdx = 0;
		int augend = 0;
		int addend = 0;
		List<Integer> usedIdxList = new ArrayList<Integer>(); 
		while (augendIdx < numbers.length) {
			if (usedIdxList.contains(augendIdx)) {
				augendIdx++;
				continue;			
			}
				
			augend = numbers[augendIdx];
			int addendIdx = augendIdx + 1;
			while (addendIdx < numbers.length) {
				if (usedIdxList.contains(addendIdx)) {
					addendIdx ++;
					continue;
				}
				addend = numbers[addendIdx];
				System.out.println((
						String.format("%d + %d = %d", augend, addend, augend + addend)
						));
				if ((augend + addend) == target) {
					usedIdxList.add(augendIdx);
					usedIdxList.add(addendIdx);
					result ++;
					addendIdx ++;
					break;
				}
				addendIdx ++;
			}
			augendIdx++;
		}
		
		
		return result;
	}
	
	public static void main(String args[]) {
		TargetSum tester = new TargetSum();
//		int[] numbers = {1, 2, 3, 4, 5};
		int[] numbers = {1, 1, 2, 45, 46};
		System.out.println(tester.findTargetSum(numbers, 47));
	}

}
