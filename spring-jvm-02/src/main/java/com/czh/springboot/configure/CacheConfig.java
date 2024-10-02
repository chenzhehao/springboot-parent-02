package com.czh.springboot.configure;

import com.czh.springboot.service.impl.CaffeineUserServiceImpl;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CacheLoader<String, Object> cacheLoaderOne() {
//        CacheLoader<String, Object> cacheLoader = Caffeine.newBuilder().build(key -> load(key));
        // 重写这个方法将oldValue值返回回去，进而刷新缓存
        return new CacheLoader<String, Object>() {
            @Override
            public Object load(String key) throws Exception {
                System.out.println("load key:"+key);
                return "test111";
            }
            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(String key, Object oldValue) throws Exception {
                return oldValue;
            }
        };
    }

    @Bean
    public LoadingCache<String, Object> cache(CacheLoader<String, Object> cacheLoaderOne) {
        return Caffeine.newBuilder()
                // 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存 最后一次写入后经过固定时间过期
//                .refreshAfterWrite(7L, TimeUnit.SECONDS)
                .expireAfterAccess(5L, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(100000)
                //软引用
                .softValues()
                .build(cacheLoaderOne);
    }

    @Bean
    public LoadingCache<String, Object> cacheRefresh() {
        return Caffeine.newBuilder()
                // 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存 最后一次写入后经过固定时间过期
//                .refreshAfterWrite(7L, TimeUnit.SECONDS)
                .expireAfterWrite(10L, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(100000)
                //软引用
                .softValues()
                .build(key -> getLoad(key));
    }

    private static Object getLoad(String key) {
        System.out.println("getLoad:"+key);
        return CaffeineUserServiceImpl.Param;
    }


}
