package com.onetest;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.Arrays;

/**
 * @author wangguize
 * @date 2022/1/14
 */
public class Loadclass2 {

    public static void main(String[] args) throws NotFoundException {
        String pathToJar = "/Users/wangguize/.m2/repository/cn/hutool/hutool-all/5.7.13/hutool-all-5.7.13.jar";
        // cn.hutool.aop.interceptor.SpringCglibInterceptor

        // Load the class representation
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(pathToJar);
        CtClass cc = pool.get("cn.hutool.aop.interceptor.SpringCglibInterceptorx"); ////////// Not reading Myclass from myjarfile.jar

        System.out.println(cc.getName());
        System.out.println(Arrays.toString(cc.getDeclaredMethods()));
    }

}
