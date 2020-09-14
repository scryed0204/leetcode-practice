package com.liamtang.otherpractice.quickSorting;

import java.util.Arrays;

public class QuickSelect {
	
	public static void main(String args[]) {
		int[] nums = new int[] {5, 6, 1, 9, 0, 4, 7, 12, 15};
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		QuickSelect kthSmallest = new QuickSelect();
		System.out.println(kthSmallest.select(nums, 0, nums.length-1, 5));
		RandomizedQuiclSorting rqs = new RandomizedQuiclSorting();
		rqs.quicksort(nums2, 0, nums2.length-1);
		System.out.println(Arrays.toString(nums2));
	}
	
	public int select(int[] nums, int front, int end, int k) {
		return quickSelect(nums, front, end, k - 1);
	}
	
	public int quickSelect(int[] nums, int front, int end, int k) {
		int pivotLoc = partition(nums, front, end);
		
		if (pivotLoc == k) {
			return nums[pivotLoc];
		} else if (pivotLoc < k) {
			return quickSelect(nums, pivotLoc + 1, end, k);
		} else {
			return quickSelect(nums, front, pivotLoc - 1, k);
		}
	}
	
	public int partition(int[] nums, int front, int end) {
		int pivot = nums[end];
		int pivotLoc = front;
		for (int i = front; i <= end; i++) {
			if (nums[i] < pivot) {
				swap(nums, pivotLoc, i);
				pivotLoc ++;
			}
		}
		swap(nums, pivotLoc, end);
		
		return pivotLoc;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
