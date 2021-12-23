package com.york.leetcode.multyThread;

import java.util.concurrent.Semaphore;

/**
 * @author york
 * @create 2020-12-09 10:14
 **/
public class Leetcode1115_1 {

    private int n;

    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public Leetcode1115_1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }
}
