package com.practice.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.filter
 * Description:
 *
 * 声明周期
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 15:56
 */

public class LifeCycleFilter implements Filter {
	public LifeCycleFilter() {
		System.out.println("filter 构造器");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 其中filterConfig是过滤器的初始配置，在web.xml中配置
		System.out.println("初始化");
		System.out.println(filterConfig.getInitParameter("dateTimePattern"));
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		System.out.println("过滤方法");
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		System.out.println("销毁方法");
	}
}
