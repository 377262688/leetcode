package com.york.leetcode;

import java.util.Arrays;

/**
 * # 215
 *
 * @author york
 * @create 2020-06-29 22:31
 **/
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int[] resluts = new int[k];
        Arrays.sort(nums);
        return nums.length - k;

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int reslut = findKthLargest(nums, k);
        System.out.println(reslut);
    }
}
