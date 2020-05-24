package com.midea.designmodel.princple;

public class OpenAndClose {
    public static void main(String[] args) {
        Draw d=new Draw();
        Sanjiaoxing s=new Sanjiaoxing(1);
        Zhengfangx z=new Zhengfangx(2);
        //如果再增加一个图形就会增加很多代码 所以要将图形抽象画 然后具体图形集成鸡肋实现抽象方法
        d.draw(s);
        d.draw(z);
    }
}

class Draw{
    public void draw(Shape s){
        if(s.type==1){
            drawSan();
        }else if(s.type==2){
            drawZheng();
        }
    }

    public void drawSan(){
        System.out.println("绘制三角形");
    }

    public void drawZheng(){
        System.out.println("绘制正方形");

    }
}

class Shape{
    public int type;
}

class Sanjiaoxing extends Shape{
    public Sanjiaoxing(int type){
        super.type=type;
    }
}

class Zhengfangx extends Shape{
    public Zhengfangx(int type){
        super.type=type;
    }
}

