package com.chenzhehao.test.springbootmoredatasource.service.impl;

import com.chenzhehao.test.springbootmoredatasource.controller.entity.resp.DDDDomainResp;
import com.chenzhehao.test.springbootmoredatasource.infrastructure.persistence.dao.CzhTableTest;
import com.chenzhehao.test.springbootmoredatasource.infrastructure.persistence.mapper.CzhTableTestMapper;
import com.chenzhehao.test.springbootmoredatasource.service.DDDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DDDServiceImpl implements DDDService {

    @Autowired
    private CzhTableTestMapper czhTableTestMapper;

    @Override
    public DDDDomainResp testDDD(String uuid) {
        CzhTableTest dddDomainModel =  czhTableTestMapper.queryByUuid(uuid);
        if (dddDomainModel == null) {
            return null;
        } else {
            DDDDomainResp dddDomainResp = new DDDDomainResp();
            dddDomainResp.setUuid(dddDomainModel.getUuid());
            dddDomainResp.setUserName(dddDomainModel.getUserName());
            return dddDomainResp;
        }

    }

}
