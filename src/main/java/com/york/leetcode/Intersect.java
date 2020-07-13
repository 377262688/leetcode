package com.york.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author york
 * @create 2020-07-13 09:22
 **/
public class Intersect {

    public static void main(String[] args) {
        int[] nums2 = {4,9,5};
        int[] nums1 = {9,4,9,8,4};
        int[] r = intersect(nums1,nums2);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + ",");
        }
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length,length2 = nums2.length;
        int[] result = new int[Math.min(length1,length2)];
        int index1 = 0,index2 = 0,index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                result[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    // 在遍历第二个数组的时候判断第一个数组是否有元素存在，如果存在则进行减1操作
    public static int[] intersect1(int[] num1,int[] num2) {
        if (num1.length > num2.length) {
            return intersect1(num2,num1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : num1) {
            int count = map.getOrDefault(i,0) + 1;
            map.put(i,count);
        }
        int[] result = new int[num1.length];
        int index = 0;
        for (int i : num2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                result[index++] = i;
                count--;
                if (count > 0) {
                    map.put(i,count);
                } else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    // 两遍遍历，最后遍历集合
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length;i++) {
            if (map.get(nums1[i]) == null) {
                map.put(nums1[i],1);
            } else {
                map.put(nums1[i],map.get(nums1[i]) + 1);
            }
        }

        Map<Integer,Integer> map1 = new HashMap<>();
        for (int j = 0; j < nums2.length; j++) {
            if (map1.get(nums2[j]) == null) {
                map1.put(nums2[j],1);
            } else {
                map1.put(nums2[j],map1.get(nums2[j]) + 1);
            }
        }
        System.out.println(map);
        System.out.println(map1);
        int repeatCount = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (map1.get(entry.getKey()) != null) {
                int count = Math.min(entry.getValue(),map1.get(entry.getKey()));
                System.out.println(entry.getKey() + " " + count);
                for (int i = 0; i < count; i++) {
                    result[repeatCount + i] = entry.getKey();
                }
                repeatCount = repeatCount + count;
            }
        }

        return Arrays.copyOfRange(result,0,repeatCount);
    }
}
