package com.onetest.lang;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;

/**
 * @author wangguize
 * @date 2022/6/9
 */
public class ParallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        final ForkJoinTask<?> task = forkJoinPool.submit(() -> {
            Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16).parallel().forEach(
                    i -> {
                        System.out.println(i + " start");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        });
        task.get();
        System.out.println("all finish");
    }
}
