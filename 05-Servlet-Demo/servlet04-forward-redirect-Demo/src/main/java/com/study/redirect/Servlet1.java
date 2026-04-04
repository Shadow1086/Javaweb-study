package com.study.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.study.redirect
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 15:00
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	/*
	* 重定向是通过HttpServletResponse对象实现的
	* 响应重定向是服务端提示下，客户端的行为
	* 客户端的地址栏是变化的，客户端至少发送了两次请求
	* 请求产生了多次，后端就会有多个request对象，此时请求中的参数不能自动传递
	* 目标资源可以是视图资源
	* 目标资源不可以是WEB-INF资源，但是可以是外部资源
	* */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 接受用户请求
		System.out.println("servlet1 执行了");
		// 响应重定向        设置相应状态码为302，同时设置location响应头
		resp.sendRedirect("s2");
	}
}
