package com.midea.designmodel.princple;


/**
 * 里氏替换原则
 *
 */
public class LishiTihuan {
    public static void main(String[] args) {
        TestA testA=new TestA();
        TestB testB=new TestB();
        //这样方法一就会失去意义 解决遵循里氏替换原则 抽出一个更为通用的基类然后利用组合的方式把TestA组合到TestB种
        testA.m1(1,2);
        testB.m1(1,2);


    }
}

class TestA{
    public void m1(int a,int b){
        System.out.println(a+b);
    }
}

class TestB extends TestA{
    public void m1(int a,int b){
        System.out.println(a-b);
    }

    public void m2(int a,int b){
        System.out.println(a*b);
    }
}
