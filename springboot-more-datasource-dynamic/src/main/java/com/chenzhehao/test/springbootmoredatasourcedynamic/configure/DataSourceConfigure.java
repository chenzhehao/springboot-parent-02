package com.chenzhehao.test.springbootmoredatasource.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


//@Configuration
public class DataSourceConfigure {

//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.one")
//    public DataSource dataSourceOne(){
//        return DruidDataSourceBuilder.create().build();
//    }
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.two")
//    public DataSource dataSourceTwo(){
//        return DruidDataSourceBuilder.create().build();
//    }


//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//
//        // 配置主数据源
//        dataSource.setUrl("jdbc:mysql://master-host:3306/yourdb");
//        dataSource.setUsername("your_username");
//        dataSource.setPassword("your_password");
//
//        // 配置备数据源
//        DruidDataSource slaveDataSource = new DruidDataSource();
//        slaveDataSource.setUrl("jdbc:mysql://slave-host:3306/yourdb");
//        slaveDataSource.setUsername("your_username");
//        slaveDataSource.setPassword("your_password");
//
//        // 添加备数据源到Balance
//        dataSource.setFilters("wall,stat"); // 设置拦截器，这里设置了wall（防火墙）和stat（统计）
//        List<DataSource> slaveDataSources = new ArrayList<>();
//        slaveDataSources.add(slaveDataSource);
//        dataSource.setSlaveDataSourceMap(slaveDataSources);
//
//        return dataSource;
//    }
}
