package com.midea.designmodel.factorypartern.abstractfactory;

public class IphoneFactory implements AbstractFactory{
    @Override
    public Phone producePhone() {
        return new IPhone();
    }
}
