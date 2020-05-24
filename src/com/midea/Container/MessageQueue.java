package com.midea.Container;

import java.util.ArrayList;
import java.util.List;

//同步容器，支持多线程往里面塞数据以及消费数据 可以继续优化 利用reetrantlock
public class MessageQueue {
    public static final MessageQueue intance=new MessageQueue();

    private MessageQueue(){

    }

    public static MessageQueue getInstance(){
        return intance;
    }


    public static List<Object> list=new ArrayList<>();

    public static Integer limit=10;

    public synchronized void enqueue(Object o) throws Exception{
        while(limit==list.size()){
            System.out.println("消息满了，开始等待...");
            wait();
        }
        if(list.size()==0){
            notifyAll();
        }
        System.out.println("添加消息"+o.toString());
        list.add(o);
    }

    public synchronized Object dequeue() throws Exception{
        while(list.size()==0){
            System.out.println("队列为空...不能消费...");
            wait();
        }
        if(list.size()==limit){
            notifyAll();
        }
        return list.remove(0);

    }

    public synchronized Integer getCount(){
        return list.size();
    }

 }
