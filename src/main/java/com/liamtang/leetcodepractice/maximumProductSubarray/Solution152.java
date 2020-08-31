package com.liamtang.leetcodepractice.maximumProductSubarray;

public class Solution152 {
	public int maxProduct(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        
        int finalResult = nums[0];
        int maxTemp = nums[0];
        int minTemp = nums[0];
        int currentSubArrayMax; 
        int currentSubArrayMin;
        int currentMaxResult;
        int currentMinResult;
        
        for (int i = 1; i < nums.length; i++) {
        	currentSubArrayMax = Math.max(maxTemp * nums[i], minTemp * nums[i]);
        	currentMaxResult = Math.max(currentSubArrayMax, nums[i]);
        	currentSubArrayMin = Math.min(maxTemp * nums[i], minTemp * nums[i]);
        	currentMinResult = Math.min(currentSubArrayMin, nums[i]);
        	finalResult = Math.max(finalResult, currentMaxResult);
        	maxTemp = currentMaxResult;
        	minTemp = currentMinResult;
        	
        } 
        
        return finalResult;   
		
		
	}
}
