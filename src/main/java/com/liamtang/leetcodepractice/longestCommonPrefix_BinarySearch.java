package com.liamtang.leetcodepractice;

public class longestCommonPrefix_BinarySearch {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i< strs.length; i++) {
            minLen = Math.min(strs[i].length(), minLen);
        }
        int low = 1;
        int high = minLen;
        while(low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low =  middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String target = strs[0].substring(0, len);
        for(int i = 1; i< strs.length; i++) {
            if (!strs[i].startsWith(target)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        String[] test = new String[] {"flower","flow","flight"};
        longestCommonPrefix_BinarySearch t = new longestCommonPrefix_BinarySearch();
        String result = t.longestCommonPrefix(test);

        System.out.println(result);

    }
}
