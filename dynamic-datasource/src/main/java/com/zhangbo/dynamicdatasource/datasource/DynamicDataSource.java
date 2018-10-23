package com.zhangbo.dynamicdatasource.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @Description
 * @Author: zhangbo
 * @Date: 2018/10/23 22:34
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceType = DynamicDataSourceHolder.getDataSource().getType();
        LOGGER.debug("thread:{},dataSourceType:{}", Thread.currentThread().getName(), dataSourceType);
        return dataSourceType;
    }
}
