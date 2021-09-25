package com.demo;

import com.demo.model.AppDTO;
import com.demo.service.AppService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * simple_class_desc
 *
 * @author wangguize
 * @date 2021/9/18
 */
@RestController
@RequestMapping("/simple")
public class SimpleController<T> extends AppDTO implements Cloneable{

    @Autowired
    AppService appService;

    T t;

    /**
     * test01_desc
     *
     * @param id id_desc
     * @return return_desc
     */
    @RequestMapping("/test01")
    public AppDTO test01(@RequestParam Integer id) {
        AppDTO app = appService.getApp(id);
        return app;
    }

    @Data
    public class InnerClass {
        String innerClassFiled;
    }

    @Data
    static class StaticInnerClass {
        String staticClassField;
    }

    @Data
    public static class PublicStaticClass {
        String publicStaticClassField;
    }

}

@Data
class SecondClass extends ArrayList<String> {
    String secondClassField;
}
