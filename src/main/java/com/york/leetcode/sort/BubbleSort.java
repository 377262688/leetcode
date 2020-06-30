package com.york.leetcode.sort;

/**
 * 冒泡排序
 * @author york
 * @create 2020-06-30 17:04
 **/
public class BubbleSort {

    public static int[] nums = {25,332,43,1,232,443,123,765,32,43,65,65,76,432,54,32,43,99,87,67};
    public static void main(String[] args) {
        printArray(nums);
        for (int j = 0; j < nums.length; j++) {
            for (int i = 1; i < nums.length - j; i++) {
                if (nums[i - 1] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
        }
        System.out.println();
        printArray(nums);
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
