package com.midea.designmodel.factorypartern.abstractfactory;

public class HuaweiFactory implements AbstractFactory{
    @Override
    public Phone producePhone() {
        return new Huawei();
    }
}
