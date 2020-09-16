package com.liamtang.otherpractice.allPairsOfSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public List<int[]> getAllPairs(int[] nums, int target) {
		
		LinkedList<Integer> waitingForPairList = new LinkedList<Integer>();
		List<int[]> result = new ArrayList<int[]>();
		int pairNum;
		int idx;
		for(int num : nums) {
			pairNum = target - num;
			if (waitingForPairList.contains(pairNum)) {
				idx = waitingForPairList.lastIndexOf(pairNum);
				waitingForPairList.remove(idx);
				result.add(new int[] {num, pairNum});
			} else {
				waitingForPairList.add(num);
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) {
//		int nums[] = {1, 5, 7, -1, 5};
//		int target = 6;
		int nums[] = {2, 5, 17, -1};
		int target = 16;
		Solution s = new Solution();
		List<int[]> result = s.getAllPairs(nums, target);
		result.forEach((pairs) -> System.out.println(Arrays.toString(pairs)));
	
	}

}
