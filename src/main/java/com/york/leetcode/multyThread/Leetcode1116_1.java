package com.york.leetcode.multyThread;

import java.util.function.IntConsumer;

/**
 * @author york
 * @create 2020-12-09 11:04
 **/
public class Leetcode1116_1 {

    private int n;

    public Leetcode1116_1(int n) {
        this.n = n;
    }

    private volatile int state = 0;

    private volatile int evenOrOdd = 1;
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (evenOrOdd == 1) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
            evenOrOdd = 2;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
            evenOrOdd = 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Leetcode1116_1 l = new Leetcode1116_1(6);
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.zero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.even(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.odd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread0.start();
        thread1.start();
        thread2.start();

        thread0.join();
        thread1.join();
        thread2.join();
    }
}
