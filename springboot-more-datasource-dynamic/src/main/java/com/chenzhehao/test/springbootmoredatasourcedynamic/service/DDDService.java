package com.chenzhehao.test.springbootmoredatasourcedynamic.service;


import com.chenzhehao.test.springbootmoredatasourcedynamic.controller.entity.resp.DDDDomainResp;

public interface DDDService {

    DDDDomainResp testDDD(String uuid);

    int testInsert(String uuid);
}
