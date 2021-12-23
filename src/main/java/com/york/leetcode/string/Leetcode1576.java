package com.york.leetcode.string;

import java.util.*;

/**
 * @author york
 * @create 2020-12-08 09:32
 **/
public class Leetcode1576 {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        char[] waitModifyChars = {'a', 'b', 'c'};
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                Set<Character> characters = new HashSet<>(2);
                if (i != 0) {
                    characters.add(chars[i - 1]);
                }
                if (i < chars.length - 1 && chars[i + 1] != '?') {
                    characters.add(chars[i + 1]);
                }

                for (char c : waitModifyChars) {
                    if (!characters.contains(c)) {
                        chars[i] = c;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }
}
