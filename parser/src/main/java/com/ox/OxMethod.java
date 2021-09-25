package com.ox;

import com.github.javaparser.ast.body.MethodDeclaration;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author wangguize
 * @date 2021/9/19
 */
@Data
public class OxMethod {

    Method method;

    MethodDeclaration methodDeclaration;



}
