package com.liamtang.otherpractice.quickSorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSortingHaore {

	public int[] sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	private void quickSort(int[] nums, int front, int end) {
		System.out.println(String.format("Front=%s, End=%s", front, end));
		if (front >= end) {
			return;
		}
		int pivotIdx = partition(nums, front, end);
		System.out.println("partition result index=" + pivotIdx);
		quickSort(nums, front, pivotIdx);
		quickSort(nums, pivotIdx + 1, end);
	}

	private int partition(int[] nums, int front, int end) {
		int pivot = nums[front];
		int i = front - 1;
		int j = end + 1;

		while (true) {
	        // Find leftmost element greater 
	        // than or equal to pivot 
			do {
				i++;
			} while (nums[i] < pivot);
			
	        // Find rightmost element smaller 
	        // than or equal to pivot			
			do {
				j--;
			} while (nums[j] > pivot);
			
			if (i >= j) {
				return j;
			}
			
			swap(nums, i, j);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		System.out.println("i=" + i + ", j=" + j + ", SWAP Result:" + Arrays.toString(nums));
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 4, 5, 3, 2, 1, 4, 4 };
		QuickSortingHaore qs = new QuickSortingHaore();
		qs.sort(nums);
		System.out.println("Final Result:" + Arrays.toString(nums));
	}

}
