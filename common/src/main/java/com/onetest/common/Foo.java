package com.onetest.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * @author guize
 * @date 2021/8/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foo {
    private String name;
    private Integer id;
}
