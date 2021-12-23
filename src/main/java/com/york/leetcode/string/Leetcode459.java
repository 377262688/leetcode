package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-08 11:03
 **/
public class Leetcode459 {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length()/2; i++) {
            if (s.length() % i == 0) {
                boolean match = true;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
