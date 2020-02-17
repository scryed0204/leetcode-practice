package com.liamtang.leetcodepractice;

import java.util.Arrays;
/**
 * 268. Missing Number (Easy)
 * @author toshiba1
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
    	//========BEST SULUTION========
        if (null == nums) {
            return 0;
        }
        int expected = nums.length * (nums.length +1) / 2;
        int actual = 0;
        for (int n : nums) actual+=n;
        
        return expected - actual;       
        //==============================
        
        //MY SOLUTION
//        Arrays.sort(nums);
//        int i = 0;
//        for (; i < nums.length; i++) {
//            if (i != nums[i]) {
//                return i;
//            }
//        }
        
        
//        return i;
    }
}
