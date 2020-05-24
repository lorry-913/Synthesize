package com.midea.designmodel.single;
//懒汉模式（双重检查机制）  线程安全
public class SingleExample3 {
    //不加volatile线程也安全，但是会发生指令重排序，就会导致在第一个线程new对象时，第二线程拿到对象里面的属性，值是乱序的 synchronized是无法阻止重排序的
    private volatile static SingleExample3 instanc;

    //private 让别人new不了
    private SingleExample3(){

    }
    //如果不加双重检查就会不安全，不加方法体是为了锁细化，优化
    public static SingleExample3 newInstance(){
        //错误的写法 第一个线程来了 判断实例为空 拿锁生成一个对象，第二个线程在第一个线程判断的时候也为空 也声称一个对象
//        if(instanc==null){
//            synchronized (SingleExample3.class){
//                try {
//                    Thread.sleep(1);
//                }catch (Exception e){
//
//                }
//                instanc=new SingleExample3();
//            }
//        }
        if(instanc==null){
            synchronized (SingleExample3.class){
                if(instanc==null){
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){

                    }
                    instanc=new SingleExample3();
                }
            }
        }
        return instanc;
    }

    public static void main(String[] args) {
        //线程安全
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(SingleExample3.newInstance().hashCode());
            }).start();
        }
    }
}
