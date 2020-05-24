package com.midea.designmodel.templateMethod;

//模板模式
// 设计一个抽象的模板 然后规定一个具体方法 具体方法里面规定了模板顺序，里面为抽象方法，抽象方法由子类来实现
public abstract class AbstractTemplate {

    //一天的模板 顺序 早中晚 具体实现子类
    //模板方法
    public final void day(){
        eatBreakfaset();
        eatLunch();
        eatDinner();
    }

    public abstract void eatBreakfaset();


    public abstract void eatLunch();

    public abstract void eatDinner();


}
