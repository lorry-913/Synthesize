package com.midea.designmodel.princple;

public class SolveOcp {
    public static void main(String[] args) {
        Draw1 draw1=new Draw1();
        Sanjiaoxing1 sanjiaoxing1=new Sanjiaoxing1();
        Zhengfangx1 zhengfangx1=new Zhengfangx1();
        draw1.draw(sanjiaoxing1);
        draw1.draw(zhengfangx1);
    }
}

//使用方
class Draw1{
    void draw(Shape1 s){
        s.draw();
    }

}

abstract class Shape1{
    int type;

    abstract void draw();
}

//提供方
class Sanjiaoxing1 extends Shape1{


    @Override
    void draw() {
        System.out.println("绘制三角形");
    }
}

class Zhengfangx1 extends Shape1{

    @Override
    void draw() {
        System.out.println("绘制正方形");
    }
}
