package com.czh.springboot.controller;

import com.czh.springboot.service.SeataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seata")
public class SeataController {

    @Autowired
    private SeataService seataService;

    @RequestMapping("/test")
    public int test() {
         seataService.test();
         return 1;
    }

}
