package com.demo.test;

import com.demo.test.model.A;
import com.demo.test.model.B;

import java.util.Date;
import java.util.List;

/**
 * @author wangguize
 * @date 2021/9/19
 */
public class FanClassImpl extends FanClass<String> implements FanInf<Date> {

    String s;

    A testa(B b) {
        return null;
    }

    @Override
    public void test1(Date date) {

    }

    @Override
    public Date test2(int i) {
        return null;
    }

    @Override
    public List<Date> test3() {
        return null;
    }
}
