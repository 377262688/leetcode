package com.york.leetcode.sort;

/**
 * 插入排序
 * @author york
 * @create 2020-06-30 18:13
 **/
public class InsertionSort {

    public static int[] nums = {25,332,43,1,232,443,123,765,32,43,65,65,76,432,54,32,43,99,87,67};

    public static void main(String[] args) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        printArray(nums);
    }

    public static void printArray(int[] nums) {
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
