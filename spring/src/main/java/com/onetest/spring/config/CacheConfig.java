package com.onetest.spring.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangguize
 * @date 2022/1/13
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>();

        caches.add(new GuavaCache("user",
                CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS).build()));

        simpleCacheManager.setCaches(caches);

        return simpleCacheManager;
    }

}
