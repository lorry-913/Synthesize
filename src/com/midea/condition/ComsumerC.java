package com.midea.condition;

public class ComsumerC implements Runnable{
    public static MessageQueue messageQueue=MessageQueue.getInstance();

    public static Object comsumerMessage(){
        Object o=messageQueue.dequeue();
        System.out.println("消费信息："+o);
        return o;
    }

    @Override
    public void run() {
        comsumerMessage();
    }
}
