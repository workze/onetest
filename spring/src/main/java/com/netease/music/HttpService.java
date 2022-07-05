package com.netease.music;

import com.netease.onecode.shc.annotation.Host;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author wangguize
 * @date 2022/7/5
 */
@Host("http://www.baidu.com")
public interface HttpService {
    @GET("/")
    Call<String> get();
}
