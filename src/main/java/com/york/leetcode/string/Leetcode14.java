package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-09 15:10
 **/
public class Leetcode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (curChar != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(curChar);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode14 l = new Leetcode14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(l.longestCommonPrefix(strs));
    }
}
