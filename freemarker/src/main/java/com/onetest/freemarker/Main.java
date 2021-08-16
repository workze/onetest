package com.onetest.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guize
 * @date 2021/8/16
 */
public class Main {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_30);

        config.setClassForTemplateLoading(Main.class, "/");

        Template temp = config.getTemplate("test.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("name", "World");

        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
    }

}
