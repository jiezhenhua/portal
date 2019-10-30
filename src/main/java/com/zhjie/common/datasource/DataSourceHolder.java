package com.zhjie.common.datasource;

/**
 * 
 * <p>
 * Title: DataSourceHolder
 * </p>
 * <p>
 * Description: 数据源进行操作的类
 * </p>
 * 
 * @author zhjie
 * @date 2019年10月20日
 */
public class DataSourceHolder {

	// 线程本地环境
	private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

	// 设置数据源
	public static void setDataSource(String customerType) {
		dataSources.set(customerType);
	}

	// 获取数据源
	public static String getDataSource() {
		return (String) dataSources.get();
	}

	// 清除数据源
	public static void clearDataSource() {
		dataSources.remove();
	}
}