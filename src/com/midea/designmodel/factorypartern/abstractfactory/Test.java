package com.midea.designmodel.factorypartern.abstractfactory;

public class Test {
    public static void main(String[] args) {
        /**
         * 接口当参数以及返回参数
         *  向上转型：继承者类型对象（子） 向 被继承者类型（父） 转型（自动转型）
         *  向下转型：被继承者类型对象（父） 向 继承者类型（子） 转型（强制转型）
         */

        AbstractFactory abstractFactory=new HuaweiFactory();
        Phone p1=abstractFactory.producePhone();
        p1.sendMessage();
        p1.playGame();


        AbstractFactory abstractFactory2=new IphoneFactory();
        Phone p2=abstractFactory2.producePhone();
        p2.sendMessage();
        p2.playGame();
    }
}
