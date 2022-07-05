package com.onetest.lang;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author wangguize
 * @date 2022/2/21
 */
public class DateUtilTest {

    public static void main(String[] args) {
        System.out.println(new Date().after(DateUtil.parse("2022-11-30 00:00:00", "yyyy-MM-dd HH:mm:ss")));
    }

}
