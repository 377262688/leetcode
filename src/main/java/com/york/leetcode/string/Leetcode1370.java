package com.york.leetcode.string;

/**
 * @author york
 * @create 2020-12-08 14:36
 **/
public class Leetcode1370 {

    public String sortString(String s) {
        int[] buckets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            buckets[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (buckets[i] > 0) {
                    sb.append((char) ('a' + i));
                    buckets[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (buckets[i] > 0) {
                    sb.append((char) ('a' + i));
                    buckets[i]--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode1370 t = new Leetcode1370();
        System.out.println(t.sortString("aaaabbbbcccc"));
    }
}
