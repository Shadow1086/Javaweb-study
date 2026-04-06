package com.practice.filter;

import com.practice.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Package: com.practice.filter
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 18:47
 */
@WebFilter(
		urlPatterns = {"/showSchedule.html","/schedule/*"}
)
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 获得session域对象
		HttpSession session = request.getSession();
		// 从session中获得登录的用户对象
		SysUser sysUser = (SysUser) session.getAttribute("sysUser");
		// 判断用户对象是否为空
		if (sysUser == null) {
			response.sendRedirect("/login.html");
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}
	}
}
