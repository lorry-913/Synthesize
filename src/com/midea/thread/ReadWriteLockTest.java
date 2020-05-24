package com.midea.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁的概念就是共享锁 和 排它锁（互斥锁）
//读锁只对读共享 不对写共享 写是全部都排斥

public class ReadWriteLockTest {

    static Lock lock =new ReentrantLock();//重入锁是排它锁

    static ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();

    static Lock readlock=rwlock.readLock();//读锁是共享锁

    static Lock writelock=rwlock.writeLock();//写锁是排它锁

    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(2000);
            System.out.println("读结束");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock,String v){
        try {
            lock.lock();
            Thread.sleep(2000);
            String str=v;
            System.out.println("写结束");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        Runnable read=()->read(lock);
        Runnable read=()->read(readlock);
        Runnable write=()->write(writelock,"heiehieh");
        for(int i=0;i<20;i++){
            new Thread(read).start();
        }
        for(int i=0;i<3;i++){
            new Thread(write).start();
        }
    }
}
