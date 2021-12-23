package com.york.leetcode.sort;

/**
 * @author york
 * @create 2020-12-06 00:12
 **/
public class maopaoSort {

    public static void main(String[] args) {
        int[] array = {9,38,15,12,6,7,11,3,4,14,19};
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        printArray(array);
    }

    public static void printArray(int[] nums) {
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
