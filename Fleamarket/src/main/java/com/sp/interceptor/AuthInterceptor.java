package com.sp.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sp.memManage.service.MemManageService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	private MemManageService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		//멤버 로긴 세션이 없으면 로긴 폼으로 보내는것
		if(session.getAttribute("member") == null){
			
			response.sendRedirect("/memmanage/login");
			
			return false; //컨트롤러 실행 이전에 실행되는넘이니까 해당요청의 컨트롤러를 실행 하지 않겠다는 것임 
		}
		
		return true; //컨트롤러를 실행 하겠다는것임 
	}
	
}











