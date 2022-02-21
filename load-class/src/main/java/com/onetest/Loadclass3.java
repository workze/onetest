package com.onetest;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.Arrays;

/**
 * @author wangguize
 * @date 2022/1/14
 */
public class Loadclass3 {

    public static void main(String[] args) throws NotFoundException {
        String pathToJar = "/Users/wangguize/.m2/repository/com/netease/music/module-war/1.0.0.1-SNAPSHOT/module-war-1.0.0.1-SNAPSHOT.war";

        // Load the class representation
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(pathToJar);

        CtClass cc = pool.get("com.simple.war.testcase.WarService");

        System.out.println(cc.getName());
        System.out.println(Arrays.toString(cc.getDeclaredMethods()));
    }

}
