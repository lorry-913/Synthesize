package com.midea.designmodel.templateMethod;

public class ConcreteTemplate extends AbstractTemplate{
    @Override
    public void eatBreakfaset() {
        System.out.println("早上吃的沙塘");
    }

    @Override
    public void eatLunch() {
        System.out.println("中午肯德基");

    }

    @Override
    public void eatDinner() {
        System.out.println("晚上麦当劳");
    }

    public static void main(String[] args) {
        AbstractTemplate abstractTemplate=new ConcreteTemplate();
        abstractTemplate.day();
    }
}
