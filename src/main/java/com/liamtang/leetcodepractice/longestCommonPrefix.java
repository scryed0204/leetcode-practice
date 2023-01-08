package com.liamtang.leetcodepractice;

public class longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String target = strs[0];
        String result = "";
        while (target.length() > 0 && result.length() == 0 ) {
            for(int i = 1; i < strs.length; i++) {
                int idx = strs[i].indexOf(target);
                if (idx != 0 ) {
                    target = target.substring(0, target.length() -1);
                    break;
                }
            }
            result = target;

        }

        return result;

    }

    public static void main(String args[]) {

        String[] test = new String[] {"flower","flow","flight"};
        longestCommonPrefix t = new longestCommonPrefix();
        String result = t.longestCommonPrefix(test);

        System.out.println(result);

    }
}
