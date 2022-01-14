package com.onetest;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author wangguize
 * @date 2022/1/14
 */
public class Loadclass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String pathToJar = "/Users/wangguize/.m2/repository/cn/hutool/hutool-all/5.7.13/hutool-all-5.7.13.jar";
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = {
                new URL("file://" + pathToJar),
                // new URL("file://" + "/Users/wangguize/.m2/repository/org/apache/poi/poi/3.17/poi-3.17.jar"),
        };
        URLClassLoader cl = URLClassLoader.newInstance(urls, null);
        final Class<?> aClass = cl.loadClass("com.onetest.A");
        System.out.println(aClass);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            try {
                Class c = cl.loadClass(className);
                final URL location = c.getProtectionDomain().getCodeSource().getLocation();
                if (className.contains("poi")) {
                    System.out.println(className + ":" + location.toString());
                }
            } catch (Throwable exception) {
                System.out.println("not found: " + className);
            }

        }
    }

}
