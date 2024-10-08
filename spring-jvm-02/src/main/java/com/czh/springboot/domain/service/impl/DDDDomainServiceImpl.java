package com.czh.springboot.domain.service.impl;

import com.czh.springboot.domain.model.DDDDomainModel;
import com.czh.springboot.domain.service.DDDDomainService;
import com.czh.springboot.infrastructure.persistence.dao.CzhTableTest;
import com.czh.springboot.infrastructure.persistence.mapper.CzhTableTestMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DDDDomainServiceImpl implements DDDDomainService {

//    @Autowired
    private CzhTableTestMapper czhTableTestMapper;

//    @Transactional(value = "customTransactionManager")
    @Transactional
    @Override
    public DDDDomainModel testDomainDDD(String uuid) {
        CzhTableTest  czhTableTest = czhTableTestMapper.queryByUuid(uuid);
        if (czhTableTest == null) {
            return null;
        } else {
            DDDDomainModel dddDomainModel = new DDDDomainModel();
            dddDomainModel.setUuid(czhTableTest.getUuid());
            dddDomainModel.setUserName(czhTableTest.getUserName());
            return dddDomainModel;
        }
    }

    public void setCzhTableTestMapper(CzhTableTestMapper czhTableTestMapper) {
        this.czhTableTestMapper = czhTableTestMapper;
    }
}
