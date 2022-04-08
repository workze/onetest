package com.test;

/**
 * @author wangguize
 * @date 2022/2/23
 */
public class Main {

    public static void main(String[] args) {
        final User user = new User();
        final App app = new App();
        app.setUserId(user.getId());
    }

}
