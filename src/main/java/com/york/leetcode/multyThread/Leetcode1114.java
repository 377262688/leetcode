package com.york.leetcode.multyThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author york
 * @create 2020-12-08 21:41
 **/
public class Leetcode1114 {


    public Leetcode1114() {

    }
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private volatile int cur = 0;
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock.lock();
        try {

        } finally {
            lock.unlock();
            condition1.signalAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (cur != 2) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
