package com.zhjie.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
/**
 * 
 * <p>Title: BaseDao</p>  
 * <p>Description: 公共dao</p>  
 * @author zhjie  
 * @date 2019年8月18日
 */
public interface BaseDao<T> {
	/**
	 * 
	 * <p>Title: insert</p>  
	 * <p>Description:插入 </p>  
	 * @param t
	 * @throws Exception
	 */
	void insert(T t)throws Exception;
	/**
	 * 
	 * <p>Title: update</p>  
	 * <p>Description:修改 </p>  
	 * @param t
	 * @throws Exception
	 */
	void update(T t)throws Exception;
	/**
	 * 
	 * <p>Title: delete</p>  
	 * <p>Description: 删除</p>  
	 * @param ukfield 主键字段
	 * @param value 主键值
	 * @throws Exception
	 */
	void delete(@Param("key")String ukfield, @Param("value")Object value)throws Exception;
	/**
	 * 
	 * <p>Title: select</p>  
	 * <p>Description: 查询</p>  
	 * @param ukfield 主键字段
	 * @param value 主键值
	 * @return
	 * @throws Exception
	 */
	T select(@Param("key")String ukfield, @Param("value")Object value)throws Exception;
	/**
	 * 
	 * <p>Title: exist</p>  
	 * <p>Description: 根据主键判断是否存在</p>  
	 * @param ukfield 主键字段
	 * @param value 主键值
	 * @return
	 * @throws Exception
	 */
	boolean exist(@Param("key")String ukfield, @Param("value")Object value)throws Exception;
	/**
	 * 
	 * <p>Title: selectLike</p>  
	 * <p>Description: 模糊查询</p>  
	 * @param key 字段
	 * @param value 字段值
	 * @return
	 * @throws Exception
	 */
	List<T> selectLike(@Param("key")String key, @Param("value")Object value)throws Exception;
}
