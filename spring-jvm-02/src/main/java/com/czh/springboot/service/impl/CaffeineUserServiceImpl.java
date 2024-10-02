package com.czh.springboot.service.impl;

import com.czh.springboot.service.CaffeineUserService;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CaffeineUserServiceImpl implements CaffeineUserService {

    public static String Param = "test";

    @Cacheable(cacheNames = "cacheNamesCaffeineCache", key = "#userId")
    @Override
    public String getUserById(String userId) {
        System.out.println("getUserById from Data");
        return "test1";
    }

    @Autowired
    private LoadingCache cache;

    @Autowired
    private LoadingCache cacheRefresh;

    @Override
    public String getUserById2(String id) {
        return cacheRefresh.get(id).toString();
    }

    @Override
    public String update(String id, String val) {
        System.out.println("update from Data");
        Param = val;
        return "true";
    }

    @Override
    public String refresh(String id) {
        System.out.println("refresh from Data");
        cacheRefresh.refresh(id);
        return "true";
    }

    @CachePut(cacheNames = "cacheNamesCaffeineCache", key = "#userId")
    public String refreshUserById(String userId) {
        System.out.println("getUserById from Data");
        return "test1";
    }


}
