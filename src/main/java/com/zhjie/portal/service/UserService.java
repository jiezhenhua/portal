package com.zhjie.portal.service;

import com.zhjie.portal.entity.User;

public interface UserService {

	/**
	 * 
	 * <p>Title: selectUser</p>  
	 * <p>Description: 通过id获取用户</p>  
	 * @param userid
	 * @return
	 */
	public User selectUser(String userid) throws Exception;
}
