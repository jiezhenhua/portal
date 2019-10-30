package com.zhjie.common.datasource;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 自定义拦截器，拦截DataSource的值
 * <p>Title: DataSourceExchange</p>  
 * <p>Description: </p>  
 * @author zhjie  
 * @date 2019年10月26日
 */
public class DataSourceExchange implements MethodBeforeAdvice,AfterReturningAdvice 

{

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		DataSourceContextHolder.clearDataSource();
	}

	@Override
	public void before(Method method, Object[] args, Object target){
		Class<?> clazz = target.getClass();
		try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(source.name());
            }
            // 方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(source.name());
            }
        } catch (Exception e) {
            System.out.println(clazz + ":" + e.getMessage());
        }

	}

}
