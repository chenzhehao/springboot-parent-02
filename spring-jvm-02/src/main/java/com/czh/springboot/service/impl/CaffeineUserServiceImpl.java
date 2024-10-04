package com.czh.springboot.service.impl;

import com.czh.springboot.infrastructure.persistence.dao.CzhTableTest;
import com.czh.springboot.infrastructure.persistence.mapper.CzhTableTestMapper;
import com.czh.springboot.service.CaffeineUserService;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CaffeineUserServiceImpl implements CaffeineUserService {

    public static String Param = "test";

    @Autowired
    private CzhTableTestMapper czhTableTestMapper;
    /**
     * 使用注解机制
     */
    @Cacheable(cacheNames = "cacheNamesCaffeineCache", key = "#userId")
    @Override
    public String getUserById(String userId) {
        log.info("getUserById from Data");
        CzhTableTest czhTableTest = czhTableTestMapper.selectByPrimaryKey(1l);
        if (czhTableTest != null) {
            return czhTableTest.getUserName();
        }
        return "test1";
    }

    @CachePut(cacheNames = "cacheNamesCaffeineCache", key = "#userId")
    public String refreshUserById(String userId) {
        log.info("getUserById from Data");
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
        log.info("update from Data");
        Param = val;
//        cacheRefresh.put(id, val);
        return "true";
    }

    @Override
    public String refresh(String id) {
        log.info("refresh from Data");
        cacheRefresh.refresh(id);
        return "true";
    }


}
