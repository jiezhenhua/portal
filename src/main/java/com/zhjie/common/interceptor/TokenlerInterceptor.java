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
				System.out.println("token验证失败，返回登录！");
				//如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
	            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
	                //告诉ajax我是重定向
	                response.setHeader("REDIRECT", "REDIRECT");
	                //告诉ajax我重定向的路径
	                response.setHeader("CONTENTPATH", request.getContextPath()+"/login/login/portal");
	                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	            }else{
	                response.sendRedirect(request.getContextPath()+"/login/login/portal");
	            }
	            return false;
			}
		}else{
			System.out.println("token为空，返回登录！");
			//如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                //告诉ajax我是重定向
                response.setHeader("REDIRECT", "REDIRECT");
                //告诉ajax我重定向的路径
                response.setHeader("CONTENTPATH", request.getContextPath()+"/login/login/portal");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }else{
                response.sendRedirect(request.getContextPath()+"/login/login/portal");
            }
			return false;
		}
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
