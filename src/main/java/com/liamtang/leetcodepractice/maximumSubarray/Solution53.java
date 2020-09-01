package com.liamtang.leetcodepractice.maximumSubarray;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int maxResult = nums[0];        
        int sum = 0;
        for (int n : nums) {
            if (sum < 0) sum = 0;
            sum += n;
            maxResult = Math.max(sum, maxResult);
        }
        
        return maxResult;
    }
}
