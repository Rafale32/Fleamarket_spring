package com.sp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter {//인터셉터 처리위한 핸들러인터샙터어댑터 상속받음
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		//멤버 라고 저장해둔 유저 로긴 객체 있으면 삭제처리해서 비워야겠지 로긴 페이지 들어왔으니까
		if(session.getAttribute("member") != null){
			session.removeAttribute("member");
		}
		
		return true;
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object memManageDTO = modelMap.get("memManageDTO");//memManageDTO 를 가지고 옴
		
		
		if(memManageDTO != null){
			
			session.setAttribute("member", memManageDTO);
			//response.sendRedirect("/fleamarket/maindetail/mmain"); 인터셉터 포스트 에서는 리다렉트 안먹힘 이미 
			//컨트롤러 에서 넘어온 넘이라 주소 처리 해놨을건데 포스트 에서는 주소를 건드릴 필요가없지
			
		}
	}

}












