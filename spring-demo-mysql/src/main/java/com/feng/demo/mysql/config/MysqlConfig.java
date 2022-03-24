package com.feng.demo.mysql.config;

import com.feng.demo.model.constant.DataSourceKey;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author fengyadong
 * @Date: 2022/3/24 20:33
 */
@Configuration
public class MysqlConfig {

    @Bean(DataSourceKey.MYSQL)
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }


}
