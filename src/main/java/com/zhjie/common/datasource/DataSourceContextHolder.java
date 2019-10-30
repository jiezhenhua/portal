package com.zhjie.common.datasource;

/**
 * 
 * <p>Title: DataSourceContextHolder</p>  
 * <p>Description: 数据源进行操作的类</p>  
 * @author zhjie  
 * @date 2019年10月26日
 */
public class DataSourceContextHolder {  

	/**
	 * 线程本地环境
	 */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  

    /** 
     * @Description: 设置数据源
     * @param dataSource  数据源名称
     * @return void 
     * @throws 
     */  
    public static void setDataSource(String dataSource) {  
        contextHolder.set(dataSource);  
    }  

    /** 
     * @Description: 获取数据源名称 
     * @param  
     * @return String 
     * @throws 
     */  
    public static String getDataSource() {  
        return contextHolder.get();  
    }  

    /** 
     * @Description: 清除数据源名称
     * @param  
     * @return void 
     * @throws 
     */  
    public static void clearDataSource() {  
        contextHolder.remove();  

    }  

}  
