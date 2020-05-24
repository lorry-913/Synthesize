package com.midea.designmodel.factorypartern.simplefactory;

public class Benz implements Car{
    @Override
    public void getName() {
        System.out.println("奔驰车");
    }
}
