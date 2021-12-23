package com.demo.testsource;



public class A extends Parent {

    B field;
    final String CONST = "xxx";

    public String method(C parameter) {
        selfMethod("string value");
        super.parentMethod();
        field.fieldMethod(CONST);
        parameter.parameterMethod(D.staticMethod());
        return null;
    }

    public void selfMethod(Object object) {
    }
}
