package com.york.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author york
 * @create 2020-12-07 21:00
 **/
public class Leetcode316 {

    public String removeDuplicateLetters(String s) {
        Map<Character,String> map = new HashMap<>();
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : chars) {
            if (map.get(character) != null) {
                continue;
            } else {
                map.put(character,"1");
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
