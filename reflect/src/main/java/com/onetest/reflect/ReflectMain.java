package com.onetest.reflect;

import com.alibaba.fastjson.JSONPath;
import com.onetest.common.Foo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author wangguize
 * @date 2021/9/23
 */
public class ReflectMain {

    public static void main(String[] args) throws Exception {
        try {
            /*Type type;

            Class clazz = Class.forName("com.onetest.reflect.A");

            Field bField = clazz.getDeclaredField("b");
            Field intfField = clazz.getDeclaredField("intf");


            Method testMethod = clazz.getDeclaredMethod("test", B.class);*/

            // /Users/wangguize/.m2/repository/com/alibaba/fastjson/1.2.70/fastjson-1.2.70.jar
            String file = JSONPath.class.getProtectionDomain().getCodeSource().getLocation().getFile();

            System.out.println("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
