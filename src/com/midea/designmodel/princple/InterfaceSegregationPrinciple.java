package com.midea.designmodel.princple;

/**
 * 接口隔离原则 (就是多分出来几个接口)
 * 1.刻划断不应该依赖她不需要的接口，即一个接口对另一个接口的依赖应该简历在最小接口上
 */
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        b.depend1(a);
    }
}

interface inter1{
    public void m1();

    public void m2();

    public void m3();
}

interface inter2{
    public void m4();

    public void m5();

    public void m6();
}

class A implements inter1,inter2{

    @Override
    public void m1() {
        System.out.println("A 实现接口1 方法 1");
    }

    @Override
    public void m2() {
        System.out.println("A 实现接口1 方法 2");

    }

    @Override
    public void m3() {
        System.out.println("A 实现接口1 方法 3");

    }

    @Override
    public void m4() {
        System.out.println("A 实现接口1 方法 4");

    }

    @Override
    public void m5() {
        System.out.println("A 实现接口1 方法 5");
    }

    @Override
    public void m6() {
        System.out.println("A 实现接口1 方法 6");
    }
}

class B {
    public void depend1(inter1 inter1){
        inter1.m1();
    }
}
