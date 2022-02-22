package com.onetest.lang;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author wangguize
 * @date 2022/2/21
 */
public class DateUtilTest {

    public static void main(String[] args) {
        final Date date = cn.hutool.core.date.DateUtil.parse("2022-02-21 11:15:01", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date.after(new Date(2021, 11, 30)));   // false
        System.out.println(date.after(DateUtil.parse("2021-11-30 00:00:00", "yyyy-MM-dd HH:mm:ss")));  // true
    }

}
