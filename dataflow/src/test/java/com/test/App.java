package com.test;

/**
 * @author wangguize
 * @date 2022/2/23
 */
public class App {

    int id;

    int userId;

    public int getId() {
        return id;
    }

    public void setId(int setIdParam) {
        this.id = setIdParam;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int setUserIdParam) {
        int varUserId = setUserIdParam;
        this.userId = varUserId;
    }

    public App create() {
        final App app = new App();
        app.setUserId(123);
        return app;
    }

    public void create2(User user) {
        this.userId = user.getId();
    }

    public void create3(App user) {
        this.userId = user.getId();
    }

    public String get1(String s) {
        String result = s;
        return result;
    }

    public void get2(User user) {
        this.userId = user.getId();
    }
}
