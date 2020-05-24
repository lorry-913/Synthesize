package com.midea.Container;

public class Producer implements Runnable{
    public static MessageQueue list= MessageQueue.getInstance();

    public String msg="";

    public Producer(String msg){
        this.msg=msg;
    }

    public static void sendMsg(Object o) {
        try{
            list.enqueue(o);
        }catch (Exception e){

        }
    }

    @Override
    public void run(){
        sendMsg("消息"+msg);
    }

    public static void main(String[] args) throws Exception{
        for(int i=0;i<5;i++){
            new Thread(new Consummer()).start();
        }
        for(int i=0;i<11;i++){
            new Thread(new Producer("消息"+i)).start();
        }

    }
}
