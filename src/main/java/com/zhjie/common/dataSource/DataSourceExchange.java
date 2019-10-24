package com.zhjie.common.dataSource;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * <p>
 * Title: DataSourceExchange
 * </p>
 * <p>
 * Description:数据源切换
 * </p>
 * 
 * @author zhjie
 * @date 2019年10月20日
 */
public class DataSourceExchange implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		DataSourceHolder.clearDataSource();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// 这里TargetDataSource是自定义的注解
		if (method.isAnnotationPresent(TargetDataSource.class)) {
			TargetDataSource datasource = method.getAnnotation(TargetDataSource.class);
			DataSourceHolder.setDataSource(datasource.name());
		} else {
			if (target.getClass().isAnnotationPresent(TargetDataSource.class)) {
				TargetDataSource datasource = target.getClass().getAnnotation(TargetDataSource.class);
				DataSourceHolder.setDataSource(datasource.name());
			}
		}

	}
}