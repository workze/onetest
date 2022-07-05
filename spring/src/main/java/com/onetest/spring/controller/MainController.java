package com.onetest.spring.controller;

import com.netease.music.HttpService;
import com.onetest.spring.service.CachedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author guize
 * @date 2021/8/19
 */
@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private CachedService cachedService;

    @Autowired
    private HttpService httpService;

    @PostConstruct
    public void init() throws IOException {
    }


    @RequestMapping(value = "echo")
    public String echo(@RequestBody String body) {
        return body;
    }

    @RequestMapping(value = "getCache", method = RequestMethod.GET)
    public String testCache() {
        System.out.println(cachedService.get(1, "123"));
        return "success";
    }

    @RequestMapping(value = "delCache", method = RequestMethod.GET, consumes = {"application/xml"})
    public String delCache() {
        cachedService.del(1);
        return "success";
    }

}
