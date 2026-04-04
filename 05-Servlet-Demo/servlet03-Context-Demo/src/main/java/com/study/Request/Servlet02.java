package com.study.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.study.Request
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 13:15
 */
@WebServlet("/s2")
public class Servlet02 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 行相关：Get/Post  uri    http/1.1
		System.out.println(req.getMethod());    // 获取请求方式
		System.out.println(req.getScheme());    // 获取请求协议
		System.out.println(req.getProtocol());  // 获取请求协议及版本号
		System.out.println(req.getRequestURI());    // 获取请求的uri，即项目内的资源路径
		System.out.println(req.getRequestURL());    // 获取请求的url，项目内资源的完整的路径
		/*
		* URI   统一资源标识符     interface URI{}                 资源定位的要求，规范
		* URL   统一资源定位符     class URL implements URI{}      http协议下，一个具体的资源路径
		* */
		System.out.println(req.getLocalPort());     // 获取本应用容器的端口号          8080
		System.out.println(req.getRemotePort());    // 获取客户端软件的端口号
		System.out.println(req.getServerPort());    // 获取客户端发起请求的端口号

		// 2. 头相关：key:value  key:value
		// 根据名字单独获取某个请求头
		System.out.println("Accept:"+req.getHeader("Accept"));
		// 获取本次请求中所有请求头的名字
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String hname = headerNames.nextElement();
			System.out.println(hname+":"+req.getHeader(hname));
		}
		System.out.println();
	}
}
