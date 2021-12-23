package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-08 21:12
 **/
public class Leetcode1614 {

    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxDepth = 0;
        int depth = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                depth++;
                maxDepth = maxDepth > depth ? maxDepth : depth;
            } else if (chars[i] == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}
