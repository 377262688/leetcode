package com.york.leetcode;

/**
 * @author york
 * @create 2020-12-09 18:09
 **/
public class Leetcode1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if ((arr[i - 1] & 1) == 0 && (arr[i - 2] & 1) == 0 && (arr[i] & 1) == 0) {
                return true;
            }
        }
        return false;
    }

}
