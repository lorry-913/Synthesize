package com.midea.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

//读屏障 写屏障 可以防止指令重排序
//volatile保证数据在线程间的可见性，以及禁止指令重排序
public class VolatileTest {
    //不能保证其原子性 必须要用synchronized或者cas操作
    //在生成汇编代码时会在volatile修饰的共享变量进行写操作的时候会多出Lock前缀的指令
    // （具体的大家可以使用一些工具去看一下，这里我就只把结果说出来）。
    // 我们想这个Lock指令肯定有神奇的地方，
    // 那么Lock前缀的指令在多核处理器下会发现什么事情了？主要有这两个方面的影响：
    //
    //将当前处理器缓存行的数据写回系统内存；
    //这个写回内存的操作会使得其他CPU里缓存了该内存地址的数据无效
    //

    public static CountDownLatch countDownLatch=new CountDownLatch(1);

    public volatile boolean is_running=true;

    public volatile List list=new ArrayList();

    public synchronized void add(Object o){list.add(o);}

    public synchronized int size(){return list.size();}


    public int count=0;

    public void increase() {
        for(int i=0;i<100;i++){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.count++;
            System.out.println(count);
        }
    }

    public void getCount(){
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
//        VolatileTest volatileTest=new VolatileTest();
//        Thread t1=new Thread(volatileTest::increase,"t1");
//        Thread t2=new Thread(volatileTest::increase,"t2");
//        Thread t3=new Thread(volatileTest::increase,"t3");
//        Thread t4=new Thread(volatileTest::increase,"t4");
//        Thread t5=new Thread(volatileTest::increase,"t5");
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
        VolatileTest volatileTest=new VolatileTest();
        Thread t=new Thread(()->{
            for(int i=0;i<10;i++){

                try {
                    if(i==5) countDownLatch.await();
                    volatileTest.add(i);
                    System.out.println("加入"+i);
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){

                }
            }

        });
        t.start();
        new Thread(()->{
            while(true){
                if(volatileTest.size()==5){
                    break;
                }

            }
            countDownLatch.countDown();
            System.out.println("t2结束");

        }).start();
        countDownLatch.await();
        System.out.println("aaaa");

    }

}
