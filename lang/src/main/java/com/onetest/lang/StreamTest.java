package com.onetest.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangguize
 * @date 2022/2/22
 */
public class StreamTest {

    public static void main(String[] args) {
        List<A> aList = new ArrayList<>();
        aList.add(new A("a", 1));
        aList.add(new A("a", 2));
        aList.add(new A("b", 3));
        aList.add(new A("b", 4));
        aList.add(new A("b", 5));
        aList.add(new A("c", 6));

        aList.stream().collect(Collectors.toMap(A::getName, a -> a, (a, b) -> a));
    }

    static class A {
        String name;
        int id;

        public A(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

}
