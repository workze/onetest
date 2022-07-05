package com.test;

import retrofit2.http.Path;

/**
 * @author wangguize
 * @date 2022/7/1
 */
@Host("https://g.hz.netease.com")
public interface Service {

    @GET("/api/v4/projects/:id")
    String get(@Path("id") String id);

}

