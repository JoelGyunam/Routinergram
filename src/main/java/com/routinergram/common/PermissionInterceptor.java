package com.routinergram.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class PermissionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(
			HttpServletRequest request
			,HttpServletResponse response
			,Object handler
			) throws IOException {
		
		HttpSession session = request.getSession();
		Integer UID =  (Integer) session.getAttribute("UID");
		String uri = request.getRequestURI();
		// 로그인이 안된 상태에서 /main 으로 시작되는 페이지는 접근 하지 못하고, 로그인 페이지로 이동.
		if(UID == null) {
			if(uri.startsWith("/main")) {
				//리다이렉트
				response.sendRedirect("/greeting");
				//Controller 까지 요청이 전달되지 않고, 중단.
				return false;
			}
		} else // 로그인이 되었을 때 접근하지 못하고 리스트페이지로 이동
			if(uri.startsWith("/greeting")) {
				response.sendRedirect("/main/feed");
				return false;
			}
		return true;
	}
}
