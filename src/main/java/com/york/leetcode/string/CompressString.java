package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-08 14:18
 **/
public class CompressString {

    public String compressString(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int curCount = 1;
        char curChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == curChar) {
                curCount++;
            } else {
                sb.append(curChar);
                sb.append(curCount);
                curChar = s.charAt(i);
                curCount = 1;
            }
        }
        sb.append(curChar);
        sb.append(curCount);
        return sb.length() >= s.length() ? s : sb.toString();
    }
}
