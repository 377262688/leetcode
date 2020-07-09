package com.york.leetcode;

import java.util.*;

/**
 * @author york
 * @create 2020-07-08 09:05
 **/
public class ReverseWords {

    public static String reverseWords(String s) {
        s = s.trim();
        System.out.println(s);
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        System.out.println(wordList);
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }

    public static void main(String[] args) {
        String s = "   hello world!";
        System.out.println(reverseWords1(s));
        String s1 = "the sky is blue";
        System.out.println(reverseWords2(s1));
    }

    public static String reverseWords1(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        while (left <= right) {
            char c = s.charAt(left);
            if (c == ' ' && sb.length() != 0) {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c != ' ') {
                sb.append(c);
            }
            left++;
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }
        String reslut = "";
        while (!stack.isEmpty()) {
            reslut = reslut + stack.pop();
            if (!stack.isEmpty()) {
                reslut = reslut + " ";
            }
        }
        return reslut;
    }

    public static String reverseWords2(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if(c == ' ') {
                while(!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(' ');
            } else {
                stack.push(c);
            }
        }
        return result.toString();
    }
}
