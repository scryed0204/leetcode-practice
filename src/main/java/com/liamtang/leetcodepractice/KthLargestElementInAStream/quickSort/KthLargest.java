package com.liamtang.leetcodepractice.KthLargestElementInAStream.quickSort;

import java.util.Arrays;

class KthLargest {
    
    private int[] nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int capacity = k <= nums.length ? k : nums.length;
        this.nums = new int[capacity];
        
        for (int i = 0; i < capacity; i++) {
            if (i == nums.length) {
                break;
            }
            this.nums[i] = nums[i];
        }
        this.k = k;
    }
    
    public int add(int val) {
        if (nums.length < k) {
            int[] newNums = new int[nums.length + 1];
            int i = 0;
            for (; i<nums.length; i++) {
                newNums[i] = nums[i];
            }
            newNums[i] = val;
            this.nums = newNums;
            quickSort(nums, 0, nums.length-1);
        } else {
            int[] temp = nums;
            int[] newNums = new int[k + 1];
            int i = 0;
            for (; i < temp.length; i++) {
                newNums[i] = temp[i];
            }
            newNums[i] = val;
            quickSort(newNums, 0, newNums.length-1);

            this.nums = new int[k];
            for (int q = 0; q < nums.length; q++) {
                this.nums[q] = newNums[q];
            }
        }
        
        
        return nums[k-1];
 
    }
    
    public void quickSort(int[] nums, int front, int end) {
        if (front >= end) {
            return;
        }
        
        int newPivot = partition(nums, front, end);
        quickSort(nums, front, newPivot);
        quickSort(nums, newPivot + 1, end);
    }
    
    public int partition(int[] nums, int front, int end) {
        int pivot = nums[front];
        int a = front-1;
        int b = end+1;
        while(true) {
            do {
                a++;
            } while (nums[a] > pivot);
            
            do {
                b--;
            } while (nums[b] < pivot);
            
            if (a >= b) {
                return b;
            }
            
            swap(nums, a, b);
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public static void main(String args[]) {
    	int k = 7;
    	int[] nums = {-10,1,3,1,4,10,3,9,4,5,1};
    	KthLargest obj = new KthLargest(k, nums);
    	System.out.println(Arrays.toString(obj.nums));
    	System.out.println(obj.add(3));
    	System.out.println(obj.add(2));
    	System.out.println(obj.add(3));
    	System.out.println(obj.add(1));
    	System.out.println(obj.add(2));
    	System.out.println(obj.add(4));
    	System.out.println(obj.add(5));
    	System.out.println(obj.add(5));
    	
    	//[null,3,3,3,3,3,3,4,4,4,5,5,5,5,5,5,5,5,6,7,7,7,7,7,7,7,7,7]
    	
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
