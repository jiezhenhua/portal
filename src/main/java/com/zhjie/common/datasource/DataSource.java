package com.zhjie.common.datasource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title: DataSource</p>  
 * <p>Description: 数据源自定义注解</p>  
 * @author zhjie  
 * @date 2019年10月26日
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

	String name() default DataSource.PORTAL;

	public static String PORTAL = "dataSourcePortal";
	public static String EMP = "dataSourceEmp";
}
