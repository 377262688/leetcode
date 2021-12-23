package com.york.leetcode.string;

import java.util.Stack;

/**
 * @author york
 * @create 2020-12-08 20:41
 **/
public class Leetcode917 {

    public String reverseOnlyLetters(String s) {
        int start = 0;
        char[] chars = s.toCharArray();
        int end = s.length() - 1;
        while (start < end) {
            if (Character.isLetter(chars[start]) && Character.isLetter(chars[end])) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;end--;
            } else {
                if (Character.isLetter(chars[start])) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return String.valueOf(chars);
    }

    public String reverseOnlyLetters1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(stack.pop());
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
