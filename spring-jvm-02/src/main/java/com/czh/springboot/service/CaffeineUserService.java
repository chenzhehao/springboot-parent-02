package com.czh.springboot.service;

public interface CaffeineUserService {

    String getUserById(String id);

    String getUserById2(String id);

    String update(String id, String val);

    String refresh(String id);
}
