package com.practice.filter;

import com.practice.common.Result;
import com.practice.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;


/**
 * Package: com.practice.filter
 * Description:
 * 允许浏览器进行跨域操作，即前端与后端的数据交互
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/11 20:33
 */
@WebFilter("/*")
public class CrosFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 允许的前端地址
		response.setHeader("Access-Control-Allow-Origin","*");
		// 允许的请求方法
		response.setHeader("Access-Control-Allow-Methods","GET ,POST,OPTIONS,DELETE,HEAD,PUT");
		// 允许的请求头
		response.setHeader("Access-Control-Allow-Headers","access-control-allow-origin,authority,content-type,version-info,X-Requested-With");

		response.setHeader("Access-Control-Max-Age","3600");
		// 允许携带Cookies
		response.setHeader("Access-Control-Allow-Credentials","true");

		// 如果是跨域遇见请求，则直接再次响应 200 业务码
		if(request.getMethod().equalsIgnoreCase("OPTIONS")){
			WebUtil.writejson(response, Result.ok(null));
		}else {
			// 非预检请求，放行即可
			chain.doFilter(request,response);
		}
	}
}
