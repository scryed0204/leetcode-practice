package com.liamtang.leetcodepractice.findKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] + o1[1]) - (o2[0] + o2[1]);
			}
        	
        });
        
        for (int i : nums1) {
        	for (int j : nums2) {
        		minHeap.add(new int[] {i, j});
        	}
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item;
        int[] current;
        while (null != minHeap.peek() && k > 0 ) {
        	item = new ArrayList<Integer>();
        	current = minHeap.poll();
        	item.add(current[0]);
        	item.add(current[1]);
        	result.add(item);
        	k--;
        }
        
        return result;
    }
    
    public static void main(String args[]) {
    	Solution373 test = new Solution373();
    	int[] nums1 = new int[] {1,2,4,5,6};
    	int[] nums2 = new int[] {3,5,7,9};
    	test.kSmallestPairs(nums1, nums2, 3).forEach( item -> {
    		System.out.println("result:" + item.toString());
    	});

    }

}
