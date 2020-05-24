package com.midea.thread;

//单例模式 比如权限操作者 只需要一个对象
//饿汉(立即)模式 线程安全 但是达不到懒加载效果，也就是用的时候需要而不是上来就实例化
public class SingleExample {
    private static final SingleExample instanc=new SingleExample();

    //private 让别人new不了
    private SingleExample(){

    }

    public static SingleExample newInstance(){
        return instanc;
    }
}
