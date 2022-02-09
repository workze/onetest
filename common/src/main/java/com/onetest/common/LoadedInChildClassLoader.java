package com.onetest.common;

public class LoadedInChildClassLoader {
    // 获取一些bytes.对于泄漏不是必需的，
    // 只是让效果出得更快一些.
    // 注意：这里开始真正泄露内存，这些bytes
    // 每次迭代都为这个final静态字段创建了!
    static final byte[] moreBytesToLeak = new byte[1024 * 10 * 1];

    static final ThreadLocal<LoadedInChildClassLoader> threadLocal = new ThreadLocal<>();

    public LoadedInChildClassLoader() {
        // 在ThreadLocal中存储对这个类的引用
        threadLocal.set(this);
    }
}