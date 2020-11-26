package com.york.leetcode;

/**
 * 斐波拉契数
 *
 * @author york
 * @create 2020-06-18 21:24
 **/
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(dpFib(10));
    }

    public static int fib(int i) {
        if (i < 0) {
            return 0;
        }
        int[] ints = new int[]{0, 1};
        ints[0] = 0;
        ints[1] = 1;
        for (int j = 3; j <= i; j++) {
            int cur = ints[0];
            ints[0] = ints[1];
            ints[1] = cur + ints[0];
        }
        return ints[0] + ints[1];
    }

    public static int dpFib(int n) {
        int[] result = new int[2];
        if (n <= 0) {
            return 0;
        }
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int cur = result[0];
            result[0] = result[1];
            result[1] = cur + result[0];
        }
        return result[1];

    }
}
