package com.midea.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;


//用于限流场景
//满员发车 什么时候达到固定线程数，什么实时执行
public class CycleBarrierTest {
    public static CyclicBarrier cyclicBarrier=new CyclicBarrier(21);

    public static void main(String[] args) {
        //不够21个线程一直等
        for(int i=0;i<20;i++){
            new Thread(()->{
                try{
                    System.out.println("开始等");
                    cyclicBarrier.await();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    }catch (Exception e){

                    }
                    System.out.println("发车");
                }catch (Exception e){

                }
            }).start();
        }
    }
}
