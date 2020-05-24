package com.midea.thread;

import java.util.concurrent.Semaphore;

//信号量 可以用来做限流，允许值几个线程执行 最大并行度
public class SemaphoreTest {
    public static Semaphore semaphore=new Semaphore(5);//默认是不公平的
    public static Semaphore semaphore2=new Semaphore(1,true);//公平的 会从队列里面等
    public static void main(String[] args) {
        for(int i=1;i<=20;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();//获得信号的允许 这时候信号量减1
                    System.out.println(Thread.currentThread().getName()+"正在运行...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"完成.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放信号量 这时候信号量减1
                }
            }).start();
        }
    }
}
