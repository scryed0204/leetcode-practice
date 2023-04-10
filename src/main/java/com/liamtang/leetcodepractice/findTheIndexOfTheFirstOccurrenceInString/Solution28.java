package com.liamtang.leetcodepractice.findTheIndexOfTheFirstOccurrenceInString;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == needle.length()) {
            return -1;
        }

        for(int i = 0; i < haystack.length() && haystack.length() - i > needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isAnswer = true;
                for(int j = 1; j < needle.length(); j ++) {
                    if (haystack.charAt( i + j) != needle.charAt(j)) {
                        isAnswer = false;
                        break;
                    }
                }
                if (isAnswer) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Solution28 s = new Solution28();
        System.out.println(s.strStr("a", "a"));
    }
}
