package com.midea.thread;

import java.util.concurrent.Exchanger;

public class ExchangeTest {
    //交换，只能两个线程进行交换 ，当执行到exchange函数时，会阻塞等待另一个线程执行到exchange，然后交换两个值
    Exchanger exchanger=new Exchanger();

    public static void main(String[] args) {

    }

}
