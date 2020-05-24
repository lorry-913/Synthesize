package com.midea.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class TestAtomic {
    //原子操作 线程安全 原理 CAS
    public static AtomicInteger count=new AtomicInteger(1);

    //longadder内部也是用cas ，不过用的是分段锁，线程非常多比atomic快
    public static LongAdder count2=new LongAdder();

    public static void increase(){
        for(int i=0;i<100;i++){
            count.incrementAndGet();

        }
    }

    public static void increase2(){
        for(int i=0;i<100;i++){
            count2.increment();

        }
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(TestAtomic::increase,"123123").start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }
}
