package com.zhjie.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhjie.common.util.JwtUtil;
/**
 * 自定义token拦截器
 * @author 70975
 *
 */
public class TokenlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setCharacterEncoding("utf-8");
		String token = request.getHeader("accessToken");
		//token存在
		if(null != token){
			//验证token是否正确
			boolean result = JwtUtil.verify(token);
			if(result){
				return true;
			}else{
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		}else{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return false;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
