package com.chenzhehao.test.springbootmoredatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chenzhehao.test.springbootmoredatasource.infrastructure.persistence.mapper")
@SpringBootApplication(scanBasePackages = "com.chenzhehao.test")
public class SpringbootMoreDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMoreDatasourceApplication.class, args);
	}

}
