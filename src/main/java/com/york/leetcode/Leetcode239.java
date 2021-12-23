package com.york.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author york
 * @create 2020-12-09 17:22
 **/
public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums,int k) {
        // 1.暴力
//        if (nums.length == 0 || k == 0) {
//            return new int[0];
//        }
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(nums[j],max);
//            }
//            res[i] = max;
//        }
//        return res;
        // 2.单调队列
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 比较尾部，将比当前小的元素移除
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 将当前元素加入队列尾部，既为当前最大元素索引
            deque.addLast(i);
            // 移除当前窗口之外的元素
            if (deque.peek() <= i - k) {
                deque.poll();
            }

            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode239 leetcode239 = new Leetcode239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = leetcode239.maxSlidingWindow(nums,3);
        printNums(res);
    }

    private static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
