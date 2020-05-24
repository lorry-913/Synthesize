package com.midea.Container;

public class Consummer implements Runnable {
    public static MessageQueue list= MessageQueue.getInstance();

    public static void recieveMsg(){
        try{
            Object o=list.dequeue();
            System.out.println("消费信息"+o);
        }catch (Exception e){

        }
    }

    @Override
    public void run() {
        recieveMsg();
    }



}
