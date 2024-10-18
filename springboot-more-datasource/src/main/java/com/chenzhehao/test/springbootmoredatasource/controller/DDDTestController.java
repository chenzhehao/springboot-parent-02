package com.chenzhehao.test.springbootmoredatasource.controller;

import com.chenzhehao.test.springbootmoredatasource.controller.entity.resp.DDDDomainResp;
import com.chenzhehao.test.springbootmoredatasource.service.DDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ddd")
public class DDDTestController {

    @Autowired
    private DDDService dddService;

    @RequestMapping("/test/{uuid}")
    public DDDDomainResp test(@PathVariable("uuid") String uuid) {
        return dddService.testDDD(uuid);
    }
}
