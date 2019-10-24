package com.zhjie.portal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhjie.common.util.AjaxJson;
import com.zhjie.common.util.JwtUtil;
import com.zhjie.common.util.RSAUtils;
import com.zhjie.portal.entity.User;
import com.zhjie.portal.service.UserService;
/**
 * 
 * <p>Title: LoginController</p>  
 * <p>Description: 用户登录</p>  
 * @author zhjie  
 * @date 2019年8月18日
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired 
	private UserService userService;
	/**
	 * 登录
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dologin")
	@ResponseBody
	public AjaxJson<Object> doLogin(@RequestBody(required=true) Map<String, Object> params, HttpSession session) throws Exception{
		AjaxJson<Object> j = new AjaxJson<>();
		String userName = (String) params.get("username");
		String password = (String) params.get("password");
		// 解密
		password = RSAUtils.decryptBase64(password.trim());
		boolean isSuccess = false;
		//身份验证成功
		User user = userService.selectUser(userName);
		if(user == null){
			j.setCode(-1);
			j.setMsg("用户不存在！");
		}else{
			if(!password.equals(user.getPassword())){
				j.setCode(-1);
				j.setMsg("密码错误！");
			}else{
				isSuccess = true;
				session.setAttribute("userInfo", user);
			}
		}
		if(isSuccess){
			//返回token
			String token = JwtUtil.sign(userName, password);
			if(token != null){
				j.setAccessToken(token);
			}else{
				j.setCode(-1);
				j.setMsg("系统异常！");
			}
		}else{
			j.setCode(-1);
			j.setMsg("系统异常！");
		}
		return j;
	}

	/**
	 * 
	 * <p>
	 * Title: getKey
	 * </p>
	 * <p>
	 * Description:获取公钥
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPublicKey/portal", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson<Object> getKey(HttpServletRequest request) {
		AjaxJson<Object> j = new AjaxJson<>();
		String publicKey = RSAUtils.generateBase64PublicKey();
		j.setData(publicKey);
		return j;
	}
}
