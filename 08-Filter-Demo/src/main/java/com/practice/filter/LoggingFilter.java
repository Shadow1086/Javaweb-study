package com.practice.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Package: com.practice.filter
 * Description:
 * <p>
 * 日志过滤器，记录请求的历史，将日志打印到控制台上
 * 1. 实现Filter接口
 * 2. 重写过滤方法
 * 3. 配置过滤器     1. web.xml 2.注解方式
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 15:21
 */

public class LoggingFilter implements Filter {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 *
	 * 过滤请求和响应的方法
	 * 1. 请求到达目标资源之前，先经过该方法
	 * 2. 该方法有能力控制请求是否继续向后到达目标资源，可以在该方法内直接像客户端做响应处理
	 * 3. 请求达到目标资源后，响应之前，还会经过该方法
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// 参数父传子
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 1. 请求到达目标资源之前的功能代码，比如：判断是否登录，校验权限是否满足。。。
//		System.out.println("loggingFilter before doFilter invoked");

		// 请求到达目标资源之前，打印日志， yyyy-MM-dd HH:mm:ss ：*** 被访问了
		String requestURI = request.getRequestURI();
		String dateTime = dateFormat.format(new Date());
		System.out.println(requestURI + "在" + dateTime + "被访问了");

		// 2. 放行代码
		long before = System.currentTimeMillis();

		chain.doFilter(request, response);

		long after = System.currentTimeMillis();

		// 3. 响应之前，HttpServletResponse 转换为响应报文之前的功能代码，  资源在yyyy-MM-dd HH:mm:ss的请求：耗时。。毫秒
//		System.out.println("loggingFilter after doFilter invoked");
		System.out.print(requestURI + "资源在" + dateTime + "的请求耗时" + (after - before) + "毫秒");


	}
}
