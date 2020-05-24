package com.midea.condition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue {
     //恶汉模式
     private static final MessageQueue messageQueue=new MessageQueue();

     private MessageQueue(){

     }

     public static MessageQueue getInstance(){
         return messageQueue;
     }


     private List list=new LinkedList();

     private Integer limit=10;

     private Lock lock=new ReentrantLock();

     private Condition producer=lock.newCondition();

     private Condition comsummer=lock.newCondition();

     public void enqueue(Object o){
         try {
             lock.lock();
             System.out.println("消息入队");
             while(limit==list.size()){
                 System.out.println("队列里消息满了");
                 producer.await();
             }
             if(list.size()==0){
                 producer.signalAll();
             }
             list.add(o);
             comsummer.signalAll();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
     }

     public Object dequeue(){
         try{
             lock.lock();
             while(list.size()==0){
                 System.out.println("队列里无消息");
                 comsummer.await();
             }
             if(list.size()==limit){
                 comsummer.signalAll();
             }
             producer.signalAll();
         }catch (Exception e){
             e.printStackTrace();
         }finally {
            lock.unlock();
         }
         System.out.println("消息出队");
         return list.remove(0);
     }


}
