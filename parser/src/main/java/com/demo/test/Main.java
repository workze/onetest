package com.demo.test;

import com.demo.test.model.A;
import com.demo.test.model.B;

/**
 * @author wangguize
 * @date 2021/9/19
 */
public class Main extends ParentClass {

    FanClassImpl fanClassImpl;

    B b;

    public A testA(B b) {
        if (true) {
        }



        Integer integer = b.getB();

        int i = integer.intValue();


        fanClassImpl.test1(null);

        return null;
    }

}
