package com.feng.demo.web.config.datasource;

import com.feng.demo.model.constant.DataSourceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengyadong
 * @Date: 2022/3/24 20:49
 */
@Configuration
public class DynamicDataSourceConfig {

    private final Map<Object, Object> dataSourceMap = new HashMap<>();

    @Autowired
    public DynamicDataSourceConfig(Map<String, DataSource> dataSourceMap) {
        dataSourceMap.forEach(this.dataSourceMap::put);
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMap.get(DataSourceKey.MYSQL));
        return dynamicDataSource;
    }

}
