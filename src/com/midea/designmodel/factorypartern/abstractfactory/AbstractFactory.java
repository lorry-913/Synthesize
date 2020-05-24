package com.midea.designmodel.factorypartern.abstractfactory;

/**
 * 1. 抽象工厂角色
 * 工厂方法模式的核心，创建产品的类必须实现该接口
 * 2. 具体工厂角色  用来创建具体实例
 * 该角色实现了抽象工厂接口，具体如何创建产品就是在该类中实现
 * 3. 抽象产品角色
 * 所有产品的超类，负责实现产品共性的抽象定义
 * 4. 具体产品角色
 * 该角色实现了抽象产品接口，负责具体不同产品的业务逻辑
 *
 *      接口当参数以及返回参数
 *      向上转型：继承者类型对象（子） 向 被继承者类型（父） 转型（自动转型）
 *     向下转型：被继承者类型对象（父） 向 继承者类型（子） 转型（强制转型）
 */
public interface AbstractFactory {
    public Phone producePhone();
}
