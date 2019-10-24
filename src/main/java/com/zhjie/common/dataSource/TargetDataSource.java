package com.zhjie.common.dataSource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>
 * Title: TargetDataSource
 * </p>
 * <p>
 * Description: 数据源自定义注解
 * </p>
 * 
 * @author zhjie
 * @date 2019年10月20日
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

	String name() default TargetDataSource.PORTAL;

	public static String PORTAL = "dataSource-portal";

	public static String EMP = "dataSource-emp";

}