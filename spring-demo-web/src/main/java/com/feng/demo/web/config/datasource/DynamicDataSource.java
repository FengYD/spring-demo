package com.feng.demo.web.config.datasource;

import com.feng.demo.model.constant.DataSourceKey;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author fengyadong
 * @Date: 2022/3/24 20:46
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}