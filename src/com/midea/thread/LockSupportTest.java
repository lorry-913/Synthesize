package com.midea.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

//锁支持 可以阻塞当前线程
public class LockSupportTest {
    public static void main(String[] args) {
       Thread t= new Thread(()->{
            for(int i=0;i<10;i++){
                try{
                    System.out.println(i);
                    if(i==5){
                        LockSupport.park();//线程停止
                    }
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){

                }finally {

                }
            }
        });
        t.start();

    }
}
