package com.midea.designmodel.single;
//这里属于懒汉（懒加载）模式
//虽然达到初始化问题，但是带来了线程不安全问题 第一个线程来了 判断为空new一个 第二个线程临界区来了也为空又new了一个
public class SingleExample2 {
    private static SingleExample2 instanc;

    //private 让别人new不了
    private SingleExample2(){

    }

    public static SingleExample2 newInstance(){
        if(instanc==null){
            try {
                Thread.sleep(1);
            }catch (Exception e){

            }
            instanc=new SingleExample2();
        }
        return instanc;
    }

    public static void main(String[] args) {
        //线程不安全
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(SingleExample2.newInstance().hashCode());
            }).start();
        }
    }
}
