package com.midea.designmodel.princple;

/**
 * 单一职责原则
 * 对于类来说，即一个类应该只负责一项职责，如果A负责两个不通的职责
 * 职责1 职责2 如果职责1需求改变影响A时，可能会对职责2影响，所以需要将A的力度分解为A1,A2
 *
 * 小结：
 *      1.降低类的复杂度，一个类只负责一个职责；
 *      2.提高可读性，可扩展性
 *      3.降低变更带来的风险
 *
 *
 */

public class SingleReponsibility {

    public static void main(String[] args) {
        //违反了单一职责规则 飞机和轮船是不可公路跑的
        //解决方案 分成3个机动车类
        Vehicle v=new Vehicle();
        v.run("汽车");
        v.run("轮船");
        v.run("飞机");

    }
}


class Vehicle{
    public void run(String string){
        System.out.println(string+"在公路上跑");
    }
}