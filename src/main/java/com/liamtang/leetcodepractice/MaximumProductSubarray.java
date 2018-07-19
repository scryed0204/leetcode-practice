package com.liamtang.leetcodepractice;

public class MaximumProductSubarray {
	// public int maxProduct(int[] nums) {
	// if (nums.length == 0) {
	// return 0;
	// }
	//
	// int maxherepre = nums[0];
	// int minherepre = nums[0];
	// int maxsofar = nums[0];
	// int maxhere, minhere;
	//
	// // { 1, -2, -4, -5, 1 };
	// for (int i = 1; i < nums.length; i++) {
	// maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]),
	// nums[i]);
	// minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]),
	// nums[i]);
	// maxsofar = Math.max(maxhere, maxsofar);
	// maxherepre = maxhere;
	// minherepre = minhere;
	// System.out.println(
	// nums[i] + ", " + maxhere + ", " + minhere + ", " + maxsofar + ", " +
	// maxherepre + ", " + minherepre);
	// }
	// return maxsofar;
	// }

	public int maxProduct(int[] nums) {
		// 0. �ˮֶǤJ�Ѽ�
		if (nums.length == 0) {
			return 0;
		}

		int result = nums[0];
		int maxTemp = nums[0];
		int minTemp = nums[0];
		int maxCurrent;
		int minCurrent;
		// 1. ���X�v�Ӥ���
		for (int i = 1; i < nums.length; i++) {
			maxCurrent = Math.max(Math.max(maxTemp * nums[i], minTemp * nums[i]), nums[i]);
			minCurrent = Math.min(Math.min(maxTemp * nums[i], minTemp * nums[i]), nums[i]);
			result = Math.max(result, maxCurrent);
			maxTemp = maxCurrent;
			minTemp = minCurrent;
			System.out.println(
					nums[i] + ", " + maxCurrent + ", " + minCurrent + ", " + result + ", " + maxTemp + ", " + minTemp);
		}

		return result;

	}

	public void printAllSubSequence(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(" " + A[k]);
				}
				System.out.println();
			}
		}
	}

	public int findMaxProductFromSubSequences(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int tempMax = nums[0];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int temp = nums[i];
				for (int k = i + 1; k <= j; k++) {
					System.out.print(" " + nums[k]);
					temp *= nums[k];
					if (temp > tempMax) {
						tempMax = temp;
					}
				}
				if (temp > tempMax) {
					tempMax = temp;
				}
				System.out.print(" = " + tempMax);
				System.out.println();
			}
		}

		return tempMax;
	}

	public static void main(String args[]) {
		MaximumProductSubarray a = new MaximumProductSubarray();
		int[] A = new int[] { 1, -2, -4, -5, 1 };
		int[] B = new int[] { -2, 0, -1 };
		int[] C = new int[] { 1, 2, 4, 5, 1 };
		int[] D = new int[] { -1, -2, -9, -6 };
		// a.printAllSubSequence(A);
		// System.out.println(a.findMaxProductFromSubSequences(A));
		System.out.println(a.findMaxProductFromSubSequences(D));
		// System.out.println(a.maxProduct(A));
		// System.out.println(a.maxProduct(B));
		// System.out.println(a.maxProduct(C));
		System.out.println(a.maxProduct(D));
	}

}
