package com.midea.condition;

public class ProducerC implements Runnable{

    public static MessageQueue messageQueue=MessageQueue.getInstance();

    public String msg;

    public ProducerC(String msg){
        this.msg=msg;
    }

    public static void sendMessage(Object o){
        System.out.println("发送信息："+o);
        messageQueue.enqueue(o);
    }

    @Override
    public void run() {
        sendMessage(this.msg);
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new ComsumerC()).start();
        }
        for(int i=0;i<16;i++){
            new Thread(new ProducerC(""+i)).start();
        }
    }
}
