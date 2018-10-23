package com.zhangbo.dynamicdatasource.aop;

import com.zhangbo.dynamicdatasource.annotation.ReadOnly;
import com.zhangbo.dynamicdatasource.datasource.DynamicDataSourceHolder;
import com.zhangbo.dynamicdatasource.enums.DataSourceType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author: zhangbo
 * @Date: 2018/10/23 23:12
 */
@Aspect
@Component
public class ReadOnlyDataSourceAspect implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadOnlyDataSourceAspect.class);

    @Around("@annotation(com.zhangbo.dynamicdatasource.annotation.ReadOnly)")
    protected Object process(ProceedingJoinPoint point, ReadOnly readOnly) {
        LOGGER.debug("begin set local method data source type to read");
        try {
            printLocalMethodName(point);
            DynamicDataSourceHolder.setDataSource(DataSourceType.READ);
        } catch (Exception e) {
            LOGGER.error("set data source type to read error", e);
        } finally {
            DynamicDataSourceHolder.clearDataSource();
            LOGGER.debug("remove local method data source type");
        }
    }

    private void printLocalMethodName(ProceedingJoinPoint point) {
        Signature signature = point.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            String methodName = methodSignature.getMethod().getName();
            LOGGER.debug("local method name:{}", methodName);
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
