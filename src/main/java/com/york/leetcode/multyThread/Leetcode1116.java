package com.york.leetcode.multyThread;

import java.util.function.IntConsumer;

/**
 * @author york
 * @create 2020-12-09 11:04
 **/
public class Leetcode1116 {

    private int n;

    public Leetcode1116(int n) {
        this.n = n;
    }

    private int evenOrOdd = 1;
    private Object lock = new Object();
    private boolean printZeroFlag = true;
    private boolean printEvenFlag = false;
    private boolean printOddFlag = false;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int tmp = n;
        while (tmp-- > 0) {
            synchronized (lock) {
                while (!printZeroFlag) {
                    lock.wait();
                }
                printNumber.accept(0);
                printZeroFlag = false;
                if (evenOrOdd == 1) {
                    printOddFlag = true;
                } else {
                    printEvenFlag = true;
                }
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (lock) {
                while (!printEvenFlag) {
                    lock.wait();
                }
                printNumber.accept(i);
                printEvenFlag = false;
                evenOrOdd = 2;
                printZeroFlag = true;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (lock) {
                while (!printOddFlag) {
                    lock.wait();
                }
                printNumber.accept(i);
                printOddFlag = false;
                evenOrOdd = 1;
                printZeroFlag = true;
                lock.notifyAll();
            }
        }
    }
}
