package com.czh.springboot.controller;

import com.czh.springboot.service.CaffeineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caffeine")
public class CaffeineController {

    @Autowired
    private CaffeineUserService userService;

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users2/{id}")
    public String getUser2(@PathVariable String id) {
        return userService.getUserById2(id);
    }

    @GetMapping("/update/{id}/{val}")
    public String update(@PathVariable String id, @PathVariable String val) {
        return userService.update(id, val);
    }

    @GetMapping("/refresh/{id}")
    public String refresh(@PathVariable String id) {
        return userService.refresh(id);
    }
}
