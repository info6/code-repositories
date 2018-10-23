package com.zhangbo.dynamicdatasource.datasource;

import com.zhangbo.dynamicdatasource.enums.DataSourceType;

import java.util.Objects;

/**
 * @Description
 * @Author: zhangbo
 * @Date: 2018/10/23 23:17
 */
public final class DynamicDataSourceHolder {

    private static final ThreadLocal<DataSourceType> DATASOURCE_THREAD_LOCAL = new ThreadLocal<>();

    public static DataSourceType getDataSource() {
        return DATASOURCE_THREAD_LOCAL.get() == null ? DataSourceType.WRITE : DATASOURCE_THREAD_LOCAL.get();
    }

    public static void setDataSource(DataSourceType dataSourceType) {
        Objects.requireNonNull(dataSourceType);
        DATASOURCE_THREAD_LOCAL.set(dataSourceType);
    }

    public static void clearDataSource() {
        DATASOURCE_THREAD_LOCAL.remove();
    }
}
