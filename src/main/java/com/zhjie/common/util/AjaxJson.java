package com.zhjie.common.util;

/**
 * 
 * <p>Title: AjaxJson</p>  
 * <p>Description: 返回结果</p>  
 * @author zhjie  
 * @date 2019年8月17日
 */
public class AjaxJson<T>{
	
/*错误码*/
private Integer code = 0;
/*提示信息*/
private String msg;
/*具体的内容*/
private T data;
/*token*/
private String accessToken;

public Integer getCode() {
    return code;
}

public void setCode(Integer code) {
    this.code = code;
}

public String getMsg() {
    return msg;
}

public void setMsg(String msg) {
    this.msg = msg;
}

public T getData() {
    return data;
}

public void setData(T data) {
    this.data = data;
}

public String getAccessToken() {
	return accessToken;
}

public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
}

}