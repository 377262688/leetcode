package com.york.leetcode.string;
/**
 * @author york
 * @create 2020-12-08 15:49
 **/
public class LeetCode859 {

    public boolean buddyStrings(String A,String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); i++) {
                count[A.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 1) {
                    return true;
                }
            }
        }
        int firstIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (endIndex == -1) {
                    endIndex = i;
                    break;
                }
            }
        }
        System.out.println(firstIndex);
        System.out.println(endIndex);
        if (firstIndex != -1 && endIndex != -1) {
            char[] chars = A.toCharArray();
            char tmp = chars[firstIndex];
            chars[firstIndex] = chars[endIndex];
            chars[endIndex] = tmp;
            return new String(chars).equals(B);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode859 t = new LeetCode859();
        System.out.println(t.buddyStrings("ab","ab"));
    }
}
