package com.test;

/**
 * @author wangguize
 * @date 2022/7/1
 */
public class Main {
    public static void main(String[] args) {
        final Service service = Factory.create(Service.class);
        final String s = service.get("1");
        System.out.println(s);
    }

}
