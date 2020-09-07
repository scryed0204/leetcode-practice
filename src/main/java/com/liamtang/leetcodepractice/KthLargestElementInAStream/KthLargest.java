package com.liamtang.leetcodepractice.KthLargestElementInAStream;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * @author kouic
 *
 */
class KthLargest {
    
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private int capacity;

    public KthLargest(int k, int[] nums) {
    	this.capacity = k;
    	if (null != nums) {
    		for (int i : nums) {
    			minHeap.add(i);
    			if (minHeap.size() > capacity) {
    				minHeap.remove();
    			}
    		}
    		
    	}

    }
    
    public int add(int val) {
    	minHeap.add(val);
    	if (minHeap.size() > capacity) {
    		minHeap.remove();
    	}
    	
    	return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */