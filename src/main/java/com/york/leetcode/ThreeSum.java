package com.york.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author york
 * @create 2020-06-18 19:53
 **/
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(nums);
        for (int i = 0;i < nums.length;i++) {
            if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {
                    if (i == k || k == j) {
                        continue;
                    }
                    if (nums[i] > nums[j] || nums[j] > nums[k]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        results.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return results;
    }
}
