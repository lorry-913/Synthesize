package com.midea.lambda;

import java.util.ArrayList;
import java.util.List;

public class LamBdaTest {
    public static void main(String[] args) {
        //有参数的lambda
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.forEach(e->{
            System.out.println(e);
        });


    }

}
