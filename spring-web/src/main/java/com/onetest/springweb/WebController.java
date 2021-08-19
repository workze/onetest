package com.onetest.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author guize
 * @date 2021/8/19
 */
@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping
    public String index() {
        return "index";
    }

}
