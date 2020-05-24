package com.midea.Container;

import java.util.ArrayList;
import java.util.List;

public class ContainerQueuq {
    public List<String> list=new ArrayList<>();
    public Integer size=10;

    public synchronized void add(String s) throws Exception{
        while(this.size==this.list.size()){
            wait();
        }
        if(this.list.size()==0){
            notifyAll();
        }
        this.list.add(s);
    }

    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for(int i=0;i<10;i++){
                String s="消息"+i;

            }
        });
    }
}
