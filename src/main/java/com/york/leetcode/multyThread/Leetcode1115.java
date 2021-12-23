package com.york.leetcode.multyThread;

/**
 * @author york
 * @create 2020-12-09 10:14
 **/
public class Leetcode1115 {

    private int n;

    private static volatile boolean flag = false;
    private static Object lock = new Object();

    public Leetcode1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (flag) {
                    lock.wait();
                }
                printFoo.run();
                flag = true;
                lock.notifyAll();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!flag) {
                    lock.wait();
                }
                printBar.run();
                flag = false;
                lock.notifyAll();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }
}
