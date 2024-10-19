package com.chenzhehao.test.springbootmoredatasource.service;


import com.chenzhehao.test.springbootmoredatasource.controller.entity.resp.DDDDomainResp;

public interface DDDService {

    DDDDomainResp testDDD(String uuid);

    int testInsert(String uuid);
}
