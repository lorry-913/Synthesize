package com.midea.designmodel.princple;

/**
 * 依赖倒置原则
 *  依赖关系传递又三种实现方式
 *      1.接口传递
 *      2.构造方法传递
 *      3.setter方法传递
 *
 * 小结:
 *     1.底层模块尽量都要有抽象类或者接口
 *     2.变量的声明类型尽量时抽象类或者接口，这样我们的对象引用就有一个缓冲层
 *
 */
public class DependcyInversion {
    public static void main(String[] args) {
        Email email=new Email();
        Wexin wexin=new Wexin();
        Person p=new Person();
        //接口多态实现
        p.receive(email);
        p.receive(wexin);
    }
}

class Email implements IReceive{
    @Override
    public void receive() {
        System.out.println("接受到短信");
    }
}
class Wexin implements IReceive{
    @Override
    public void receive() {
        System.out.println("接受到微信");
    }
}


interface IReceive{
    public void receive();
}

class Person{
    //跟接口发生依赖 传递接口
    public void receive(IReceive receive){
        receive.receive();
    }
}