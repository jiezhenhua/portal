package com.zhjie.portal.entity;

import org.springframework.stereotype.Component;
/**
 * 
 * <p>Title: User</p>  
 * <p>Description: 用户实体类</p>  
 * @author zhjie  
 * @date 2019年8月18日
 */
@Component
public class User {

	private String userid;
	private String username;
	private String password;
	
	//用于分页的字段
	private int  startSize;//开始条数
	private int  endSize;//结束条数
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getStartSize() {
		return startSize;
	}
	public void setStartSize(int startSize) {
		this.startSize = startSize;
	}
	public int getEndSize() {
		return endSize;
	}
	public void setEndSize(int endSize) {
		this.endSize = endSize;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
