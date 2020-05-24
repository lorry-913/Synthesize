package com.midea.designmodel.factorypartern.abstractfactory;

public class IPhone implements Phone{
    @Override
    public void sendMessage() {
        System.out.println("苹果手机发送信息");
    }

    @Override
    public void playGame() {
        System.out.println("苹果手机打游戏");

    }
}
