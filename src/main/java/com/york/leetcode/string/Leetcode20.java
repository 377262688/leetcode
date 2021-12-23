package com.york.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author york
 * @create 2020-06-20 10:34
 * 有效的括号
 **/
public class Leetcode20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (char c : chars) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                if (!map.containsKey(c)) {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                if (!map.get(c).equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
