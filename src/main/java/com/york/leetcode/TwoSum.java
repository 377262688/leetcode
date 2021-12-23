package com.york.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/solution/
 * @author york
 * @create 2020-06-16 22:05
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
        // 暴力解法
        for (int i = 0;i < nums.length - 1;i++) {
            for (int j = i + 1;j < nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        // 根据map来遍历一次
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i],i);
            } else {
                return new int[]{map.get(target - nums[i]),i};
            }
        }
        throw new IllegalArgumentException("");
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                result[0] = target - nums[i];
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("");
    }


}
