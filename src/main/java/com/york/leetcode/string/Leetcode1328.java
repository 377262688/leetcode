package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-08 14:57
 **/
public class Leetcode1328 {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        boolean flag = false;
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                flag = true;
                break;
            }
        }
        if (!flag) {
            chars[palindrome.length() - 1] = 'b';
        }
        return new String(chars);
    }
}
