package com.onetest.spring.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wangguize
 * @date 2022/1/13
 */
@Service
public class CachedService {

    @Cacheable(cacheNames = "user")
    public String get(Integer id) {
        return new Date().toString();
    }

    @Cacheable(cacheNames = "app")
    public String get2(Integer id) {
        return new Date().toString();
    }

    @CacheEvict(cacheNames = "app", allEntries = true)
    public String del(Integer id) {
        return new Date().toString();
    }
}
