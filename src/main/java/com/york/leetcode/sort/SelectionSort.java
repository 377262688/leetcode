package com.york.leetcode.sort;

/**
 * 选择排序
 * @author york
 * @create 2020-06-30 17:12
 **/
public class SelectionSort {

    public static int[] nums = {25,332,43,1,232,443,123,765,32,43,65,65,76,432,54,32,43,99,87,67};

    public static void main(String[] args) {
        printArray(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[maxIndex] > nums[j]) {
                    maxIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = tmp;
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
