package com.liamtang.leetcodepractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwosumSolution {

	// TWO SUM
	public int[] twosum(int[] nums, int target) {
		// Solution 1:
		// int temp;
		// int tempIdx;
		// if (nums.length > 1) {
		// for (int idx = 0; idx < nums.length; idx++) {
		// temp = nums[idx];
		// tempIdx = idx;
		// for (int idx2 = 0; idx2 < nums.length; idx2++) {
		// if (idx2 == tempIdx) {
		// continue;
		// } else {
		// if (temp + nums[idx2] == target) {
		// System.out.println(temp + " + " + nums[idx2] + " = " + target);
		// return new int[] { tempIdx, idx2 };
		// }
		// }
		// }
		// }
		// }
		// End of Solution 1

		// // Solution 2
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int idx = 0; idx < nums.length; idx++) {
			int complement = target - nums[idx];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), idx };
			}
			map.put(nums[idx], idx);
		}
		// // End of Solution 2

		throw new IllegalArgumentException("No solution");
	}

	public static void main(String args[]) {
		String target = "1234";
		String subStr = target;

		while (target.length() > 0) {
			System.out.println(target.indexOf("123"));
			System.out.println(target);
			target = target.substring(0, target.length() - 1);
		}

		HashSet<String> container = new HashSet();
		


	}

}
