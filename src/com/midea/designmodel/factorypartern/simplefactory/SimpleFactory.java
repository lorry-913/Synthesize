package com.midea.designmodel.factorypartern.simplefactory;

//简单工厂模式
// 简单工厂模式是一个由工厂对象决定创建出哪一种产品类的实例，又叫静态工厂方法模式。
// 缺点每次新家一个类都需要增加大量代码和分支 违背了依赖倒置原则
public class SimpleFactory {
    public static Car getInstance(String type){
        if(type.equals("宝马")){
            return new Bwm();
        }else if(type.equals("奔驰")){
            return new Benz();
        }
        return null;
    }

    public static void main(String[] args) {
        Car c=SimpleFactory.getInstance("宝马");
        c.getName();
        Car c1=SimpleFactory.getInstance("奔驰");
        c1.getName();
    }
}
