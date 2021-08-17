package com.onetest.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guize
 * @date 2021/8/17
 */
@RestController
@RequestMapping("/longPoll")
public class LongPollingController {

    @SuppressWarnings("AlibabaThreadPoolCreation")
    private ExecutorService bakers = Executors.newFixedThreadPool(5);

    List<DeferredResult<String>> listeners = new ArrayList<>();

    @GetMapping("getConfig")
    public DeferredResult<String> getConfig(@RequestParam Long timeout) {
        DeferredResult<String> result = new DeferredResult<>(timeout);
        result.onTimeout(()->{
            result.setResult("timeout!");
        });
        listeners.add(result);
        return result;
    }

    @GetMapping("publishConfig")
    public String publishConfig() {
        final Iterator<DeferredResult<String>> iterator = listeners.iterator();
        while (iterator.hasNext()) {
            final DeferredResult<String> next = iterator.next();
            next.setResult("notified!");
            iterator.remove();
        }
        return "success";
    }

}
