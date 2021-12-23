package com.york.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author york
 * @create 2020-12-08 17:16
 **/
public class Mianshi1626 {

    public int calculate(String s) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        while (index < s.length()) {
            char curChar = s.charAt(index);
            if (curChar == ' ') {
                index++;
                continue;
            }
            if (curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/') {
                index++;
                while (index < s.length() && s.charAt(index) == ' ') {
                    index++;
                }
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
                index++;
            }
            switch (curChar) {
                case '+':
                    break;
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = deque.pop() * num;
                    break;
                case '/':
                    num = deque.pop() / num;
                    break;
                default:
                    break;
            }
            deque.push(num);
        }
        while (!deque.isEmpty()) {
            result += deque.pop();
        }
        return result;
    }

    public static void main(String[] args) {
//        Mianshi1626 m = new Mianshi1626();
//        System.out.println(m.calculate("3/2"));
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');

    }
}
