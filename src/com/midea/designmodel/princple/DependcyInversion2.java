package com.midea.designmodel.princple;

/**
 * 依赖倒置
 * 构造器注入
 */
public class DependcyInversion2 {
    public static void main(String[] args) {

    }

}

interface TestI{
    public void m1();
}

interface Test2{
    public void m2();
}

class Test implements TestI{
    public Test2 test2;

    public Test(Test2 test2){
        this.test2=test2;
    }

    @Override
    public void m1() {
        this.test2.m2();
    }
}
