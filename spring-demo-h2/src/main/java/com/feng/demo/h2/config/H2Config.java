package com.feng.demo.h2.config;

import com.feng.demo.model.constant.DataSourceKey;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author fengyadong
 * @Date: 2022/3/24 20:39
 */
@Configuration
public class H2Config {
    
    @Bean(DataSourceKey.H2)
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    public DataSource h2DataSource(){
        return DataSourceBuilder.create().build();
    }
}
