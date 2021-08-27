package com.onetest.lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author guize
 * @date 2021/8/26
 */
public class FastJsonMain {
    public static void main(String[] args) {
        System.out.println(JSON.parseObject(JSON.toJSONString("abc"), String.class));
        System.out.println(JSON.toJSONString("abc"));
        // System.out.println(JSON.parseObject("abc", String.class));

        final Double aDouble = JSON.parseObject("1.2", double.class);

    }
}
