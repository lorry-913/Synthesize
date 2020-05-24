package com.midea.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQS {
    /**
     * reetrantlock底层用AQS，是可重入锁，但是不同于synchronized
     * synchronized是不可中断的
     *
     * reetrantlock  有lock()和unlock()方法
     * ReentranLock分为公平锁和非公平锁（默认构造函数）  公平就会去等待队列里等待
     *
     * 而非公平锁 lock()方法首先是
     *          lock() {
     *             if (compareAndSetState(0, 1))
     *                 setExclusiveOwnerThread(Thread.currentThread());
     *             else
     *                 acquire(1);
     *         }
     *公平锁lock() {
     *         //调用了AQS的acquire函数,这是关键函数之一
     *         acquire(1);
     *     }
     *
     *
     */

}
