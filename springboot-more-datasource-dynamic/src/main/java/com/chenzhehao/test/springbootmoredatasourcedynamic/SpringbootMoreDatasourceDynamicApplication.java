package com.chenzhehao.test.springbootmoredatasourcedynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chenzhehao.test.springbootmoredatasourcedynamic.infrastructure.persistence.mapper")
@SpringBootApplication(scanBasePackages = "com.chenzhehao.test")
public class SpringbootMoreDatasourceDynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMoreDatasourceDynamicApplication.class, args);
	}

}
