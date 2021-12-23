package com.york.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author york
 * @create 2020-12-11 16:34
 **/
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {2,4,6,7,8,9};
        System.out.println(mergeSortedArray.merge(nums1,nums2));
    }

    public List<Integer> merge(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        int i = 0,j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                list.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            list.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            list.add(nums2[j]);
            j++;
        }
        return list;
    }
}
