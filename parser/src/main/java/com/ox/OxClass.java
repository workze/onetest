package com.ox;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import lombok.Data;

import java.util.List;

/**
 * @author wangguize
 * @date 2021/9/19
 */
@Data
public class OxClass {

    Class clazz;

    ClassOrInterfaceDeclaration classOrInterfaceDeclaration;

    List<OxMethod> methods;

    String name;

    String simpleName;

    boolean isInterface() {
        return false;
    }

}
