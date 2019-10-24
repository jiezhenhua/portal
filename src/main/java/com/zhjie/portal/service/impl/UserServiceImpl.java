package com.zhjie.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhjie.portal.dao.UserDao;
import com.zhjie.portal.entity.User;
import com.zhjie.portal.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao ;
	@Override
	public User selectUser(String userid) throws Exception {

		return userDao.select("userid", userid);
	}

}
