package com.midea.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//倒数门栓 数到了 门栓开了

/**
 * CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，
 * 再继续执行。使用一个计数器进行实现。
 * 计数器初始值为线程的数量。
 * 当每一个线程完成自己任务后，计数器的值就会减一。
 * 当计数器的值为0时，表示所有的线程都已经完成一些任务，
 * 然后在CountDownLatch上等待的线程就可以恢复执行接下来的任务。
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                        latch.countDown();//当前线程调用此方法，则计数减一
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);//执行完一个线程计数器减一
        }

        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
            latch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
