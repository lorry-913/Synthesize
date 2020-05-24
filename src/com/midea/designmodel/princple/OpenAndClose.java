package com.midea.designmodel.princple;

/**
 * 开闭原则
 * 1.开闭原则时一个软件实体类/函数/模块应该对扩展开放（对提供方），对修改关闭（对使用方）
 * 用抽象构件
 */
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
     void draw(Shape s){
        if(s.type==1){
            drawSan();
        }else if(s.type==2){
            drawZheng();
        }
    }

     void drawSan(){
        System.out.println("绘制三角形");
    }

     void drawZheng(){
        System.out.println("绘制正方形");

    }
}

class Shape{
     int type;
}

class Sanjiaoxing extends Shape{
     Sanjiaoxing(int type){
        super.type=type;
    }
}

class Zhengfangx extends Shape{
     Zhengfangx(int type){
        super.type=type;
    }
}

