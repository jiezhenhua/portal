package com.zhjie.common.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * <p>
 * Title: DynamicDataSource
 * </p>
 * <p>
 * Description: 动态数据源（依赖于spring）
 * </p>
 * 
 * @author zhjie
 * @date 2019年10月20日
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.getDataSource();
	}

}