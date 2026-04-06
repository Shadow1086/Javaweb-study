package com.practice.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Package: com.practice.filter
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 16:50
 */

public class FilterChain3 implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter3 before doFilter invoked");
		chain.doFilter(request,response);
		System.out.println("filter3 after doFilter invoked");
	}
}
