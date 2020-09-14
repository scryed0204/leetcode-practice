package com.liamtang.otherpractice.quickSorting;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuiclSorting {
	
	public static void main(String args[]) {
		
		int[] nums = new int[] {5, 6, 1, 9, 0, 4, 7, 12, 15};
		RandomizedQuiclSorting rqs = new RandomizedQuiclSorting();
		rqs.quicksort(nums, 0, nums.length-1);
		
		System.out.println(Arrays.toString(nums));
	}
	
    public void quicksort(int[] nums, int front, int end){
        if(front>=end) return;
        if(front<0) return;
        if(end>nums.length -1) return;
        
        int pivotIdx = partition(nums, front, end);
        quicksort(nums, front, pivotIdx-1);
        quicksort(nums, pivotIdx+1, end);
    }
	
	private int partition(int[] nums, int front, int end) {
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
//		//Get a random pivot between beg and end
//		int pivotIndex = new Random().nextInt(end - front) + front;
//		
//		int pivot = nums[pivotIndex];
//		
//		//New position of pivot element
//		int last = end;
//		
//		swap(nums, end, pivotIndex);
//		end--;
//		
//		int newPivotIdx = front -1;
//		
//		for (int j = front; j <= end; j++) {
//			if (nums[j] < pivot) {
//				newPivotIdx++;
//				swap(nums, newPivotIdx, j);
//			}
//		}
//		
//		newPivotIdx++;
//		swap(nums, newPivotIdx, last);
//		
//		return newPivotIdx;		
	}
	
	
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
