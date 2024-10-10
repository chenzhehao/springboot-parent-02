package com.czh.springboot.configure.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public CustomTransactionManager customTransactionManager(DataSource dataSource) {
        return new CustomTransactionManager(dataSource);
    }
}