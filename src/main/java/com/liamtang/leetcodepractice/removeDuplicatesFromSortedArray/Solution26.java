package com.liamtang.leetcodepractice.removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int i = 1;
        int j = i;
        int temp = j  + 1;
        while(j < nums.length) {
            int foundVal = nums[j];
            while(foundVal == current && temp < nums.length) {
                foundVal = nums[temp];
                temp++;
            }
            if (current != foundVal) {
                nums[i] = foundVal;
                current = nums[i];
                i++;
            }

            j = temp;
            temp++;

        }

        nums = Arrays.copyOfRange(nums, 0, i);
        System.out.println(Arrays.toString(nums));

        return i;
    }

    public static void main(String[] args)
    {
        Solution26 sol = new Solution26();
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,0};

        sol.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));

    }
}
