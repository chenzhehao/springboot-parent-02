package com.czh.springboot.service.impl;

import com.czh.springboot.controller.entity.resp.DDDDomainResp;
import com.czh.springboot.domain.model.DDDDomainModel;
import com.czh.springboot.domain.service.DDDDomainService;
import com.czh.springboot.service.DDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DDDServiceImpl implements DDDService {

    @Autowired
    private DDDDomainService dddDomainService;

    @Override
    public DDDDomainResp testDDD(String uuid) {
        DDDDomainModel dddDomainModel =  dddDomainService.testDomainDDD(uuid);
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
