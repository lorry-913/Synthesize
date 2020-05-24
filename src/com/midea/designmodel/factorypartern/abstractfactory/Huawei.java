package com.midea.designmodel.factorypartern.abstractfactory;

public class Huawei implements Phone{
    @Override
    public void sendMessage() {
        System.out.println("华为手机发送信息");
    }

    @Override
    public void playGame() {
        System.out.println("华为手机打游戏");
    }
}
