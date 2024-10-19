package com.chenzhehao.test.springbootmoredatasource.service.impl;

import com.chenzhehao.test.springbootmoredatasource.controller.entity.resp.DDDDomainResp;
import com.chenzhehao.test.springbootmoredatasource.infrastructure.persistence.dao.CzhTableTest;
import com.chenzhehao.test.springbootmoredatasource.infrastructure.persistence.mapper.CzhTableTestMapper;
import com.chenzhehao.test.springbootmoredatasource.service.DDDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.sql.DataSourceDefinitions;

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

    @Override
    public int testInsert(String uuid) {
        CzhTableTest record = new CzhTableTest();
        record.setUuid(uuid);
        record.setUserName(uuid);
        record.setDeleteFlag((byte) 0);
        record.setCreatedId(1);
        record.setCreatedTime(new java.util.Date());
        record.setModifiedId(1);
        record.setModifiedTime(new java.util.Date());
        return czhTableTestMapper.insert(record);
    }

}
