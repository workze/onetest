package com.demo.test;

import java.util.List;

/**
 * @author wangguize
 * @date 2021/9/19
 */
public interface FanInf<T> {

    void test1(T t);

    T test2(int i);

    List<T> test3();
}
