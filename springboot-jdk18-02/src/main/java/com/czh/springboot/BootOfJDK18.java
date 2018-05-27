package com.czh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: BootOfRocketMq.java
 * @Description: Copyright: Copyright (c) 2018
 * @Company: www.chenzhehao.com
 * @author chenzhehao
 * @date 2018年5月24日
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class BootOfJDK18 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootOfJDK18.class, args);
	}

	@RequestMapping("/")
	public Object RMIboot() {
		return "success";
	}
}
