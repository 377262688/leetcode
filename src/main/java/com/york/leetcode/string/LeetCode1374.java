package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-08 15:34
 **/
public class LeetCode1374 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            int n1 = n - 1;
            for (int i = 0; i < n1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }

        return sb.toString();
    }
}
