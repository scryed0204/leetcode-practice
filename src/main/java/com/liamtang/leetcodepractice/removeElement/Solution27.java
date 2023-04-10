package com.liamtang.leetcodepractice.removeElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int currentRetreat = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                currentRetreat++;
                continue;
            }
            nums[i-currentRetreat] = nums[i];
        }

        return nums.length - currentRetreat;
    }
}
