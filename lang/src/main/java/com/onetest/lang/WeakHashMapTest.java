package com.onetest.lang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author wangguize
 * @date 2022/2/9
 */
public class WeakHashMapTest {

    @Data
    @AllArgsConstructor
    static class A {
        String name = "a";
    }

//    public static void main(String[] args) {
////        Map<Integer, SoftReference<byte[]>> map = new HashMap<>();
//         Map<A, byte[]> map = new WeakHashMap<>();
//        for (int i = 0; i < 2000; i++) {
//            System.out.println(i);
////            map.put(i, new SoftReference<>(new byte[1024 * 1024]));
//            map.put(new A("i"), new byte[1024 * 1024]);
//            map.get(i);
//        }
//    }

    public static void main(String[] args) {
//        Map<Integer, SoftReference<byte[]>> map = new HashMap<>();
        Map<String, byte[]> map = new WeakHashMap<>();
        for (int i = 0; i < 2000; i++) {
            System.out.println(i);
//            map.put(i, new SoftReference<>(new byte[1024 * 1024]));
            map.put(new String("" + 1), new byte[1024 * 1024]);
            map.get(i);
        }
    }


//    public static void main(String[] args) {
////        Map<Integer, SoftReference<byte[]>> map = new HashMap<>();
//        Map<Integer, byte[]> map = new WeakHashMap<>();
//        for (int i = 0; i < 2000; i++) {
//            System.out.println(i);
////            map.put(i, new SoftReference<>(new byte[1024 * 1024]));
//            map.put(i, new byte[1024 * 1024]);
//            map.get(i);
//        }
//    }
}
