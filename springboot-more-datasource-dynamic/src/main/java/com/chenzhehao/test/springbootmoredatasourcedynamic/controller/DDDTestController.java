package com.chenzhehao.test.springbootmoredatasourcedynamic.controller;

import com.chenzhehao.test.springbootmoredatasourcedynamic.controller.entity.resp.DDDDomainResp;
import com.chenzhehao.test.springbootmoredatasourcedynamic.service.DDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ddd")
public class DDDTestController {

    @Autowired
    private DDDService dddService;

    /**
     * 测试读写分离
     * @param uuid
     * @return
     */
    @GetMapping("/test/query/{uuid}")
    public DDDDomainResp test(@PathVariable("uuid") String uuid) {
        return dddService.testDDD(uuid);
    }

    @PostMapping("/test/insert/{uuid}")
    public Integer testInsert(@PathVariable("uuid") String uuid) {
        return dddService.testInsert(uuid);
    }
}


