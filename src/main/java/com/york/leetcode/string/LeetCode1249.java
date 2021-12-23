package com.york.leetcode.string;

import java.util.*;

/**
 * @author york
 * @create 2020-12-08 15:18
 **/
public class LeetCode1249 {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> removeIndexSet = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    removeIndexSet.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            removeIndexSet.add(stack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndexSet.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
