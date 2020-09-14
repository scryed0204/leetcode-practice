package com.liamtang.otherpractice.quickSorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSorting {

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
		quickSort(nums, front, pivotIdx - 1);
		quickSort(nums, pivotIdx + 1, end);
	}

	private int partition(int[] nums, int front, int end) {
		System.out.println("Partitioning:" + Arrays.toString(nums) + ", Front:" + front + ", End:" + end);
//		Random rand = new Random();
//		int pivot_idx = front + rand.nextInt(end - front);
		int pivot_idx = end;
		int pivot = nums[pivot_idx];
		System.out.println("pivot_idx=" + pivot_idx + ", pivot=" + pivot);
		int i = front - 1;

		for (int j = front; j < end; j++) {
			if (nums[j] < pivot) {
				i++;
				swap(nums, i, j);
			}
		}

		System.out.println("-----------------------------");
		i++;
		swap(nums, i, pivot_idx);
		System.out.println("-----------------------------");
		
		return i;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		System.out.println("i=" + i + ", j=" + j + ", SWAP Result:" + Arrays.toString(nums));
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 5, 3, 2, 1, 4 };
		QuickSorting qs = new QuickSorting();
		qs.sort(nums);
		System.out.println("Final Result:" + Arrays.toString(nums));
	}

}
