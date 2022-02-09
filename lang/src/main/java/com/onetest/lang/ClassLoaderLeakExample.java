package com.onetest.lang;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * ClassLoader泄漏演示
 *
 * <p>要查看实际运行效果，请将此文件复制到某个临时目录，
 * 然后运行：
 * <pre>{@code
 *   javac ClassLoaderLeakExample.java
 *   java -cp .ClassLoaderLeakExample
 * }</pre>
 *
 * <p>可以看到内存不断增加！在我的系统上，使用JDK 1.8.0_25，开始
 * 短短几秒钟就收到了OutofMemoryErrors
 *
 * <p>这个类用到了一些Java 8功能，主要用于
 * I/O 操作同样的原理可以适用于
 * Java 1.2以后的任何Java版本
 */
public final class ClassLoaderLeakExample {

    static volatile boolean running = true;

    public static void main(String[] args) throws Exception {
        Thread thread = new LongRunningThread();
        try {
            thread.start();
            System.out.println("Running, press any key to stop.");
            System.in.read();
        } finally {
            running = false;
            thread.join();
        }

        /*while (true) {
            final Thread thread = new Thread(() -> {
                try {
                    loadAndDiscard();
                    Thread.sleep(10);
                } catch (Exception e) {
                    //
                }
            });
            thread.start();
            thread.join();
        }*/
    }

    /**
     * 线程的实现只是循环调用
     * {@link #loadAndDiscard()}
     */
    static final class LongRunningThread extends Thread {
        @Override
        public void run() {
            while (running) {
                try {
                    loadAndDiscard();
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    System.out.println("Caught InterruptedException, shutting down.");
                    running = false;
                }
            }
        }
    }

    /**
     * 这是一个简单的ClassLoader实现，只能加载一个类
     * 即LoadedInChildClassLoader类.这里需要解决一些麻烦
     * 必须确保每次得到一个新的类
     * (而非系统class loader提供的
     * 重用类).如果此子类所在JAR文件不在系统的classpath中,
     * 不需要这么麻烦.
     */
    static final class ChildOnlyClassLoader extends URLClassLoader {

        public ChildOnlyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }
    }

    /**
     * Helper方法会创建一个新的ClassLoader, 加载一个类,
     * 然后丢弃对它们的所有引用.从理论上讲，应该不会影响GC
     * 因为没有引用可以逃脱该方法! 但实际上，
     * 结果会像筛子一样泄漏内存.
     */
    static void loadAndDiscard() throws Exception {
        final URL url = new URL("file:///Users/wangguize/.m2/repository/com/onetest/common/1.0.0-SNAPSHOT/common-1.0.0-SNAPSHOT.jar");
        ClassLoader childClassLoader = new ChildOnlyClassLoader(new URL[]{url}, null);
        Class<?> childClass = Class.forName("com.onetest.common.LoadedInChildClassLoader", true, childClassLoader);
        // Class<?> childClass = Class.forName("com.onetest.common.Foo", true, childClassLoader);
        final Object instance = childClass.newInstance();
        System.out.println(instance);
        // 该方法返回时，将无法访问
        // childClassLoader或childClass的引用，
        // 但是这些对象仍会成为GC Root!
    }

}