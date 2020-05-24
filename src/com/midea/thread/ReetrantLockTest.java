package com.midea.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁 synchronized是可重入锁 同一个类中的锁是同一把锁  子类和父类是同一把锁
//ReentrantLock比synchronized灵活 可以手动枷锁释放锁
//ReentrantLock可以变成公平锁，公平锁会去队列里等，而不是直接去抢锁
//底层也是CAS实现
public class ReetrantLockTest {
    Lock lock=new ReentrantLock(true);
    synchronized void m1(){
        for(int i=0;i<10;i++){
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){

            }
            if(i==5) m2();//重新拿到这把锁
            System.out.println(i);
        }
    }

    synchronized void m2(){
        System.out.println("m2。。。");
    }

    void m3(){
        try{
            lock.lock();
            for(int i=0;i<10;i++){
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){

                }
                System.out.println(i);
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReetrantLockTest reetrantLockTest=new ReetrantLockTest();
        new Thread(reetrantLockTest::m1).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
//        new Thread(reetrantLockTest::m2).start();
    }
}
