package com.practice.servlet1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Package: com.practice.servlet1
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 14:44
 */
@WebServlet("/s2")
public class Servlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求数据
		// 请求域
		System.out.println("请求域：" + (String) req.getAttribute("request"));

		// 会话域
		System.out.println("会话域：" + (String) req.getSession().getAttribute("session"));

		// 应用域
		System.out.println("应用域：" + (String) getServletContext().getAttribute("application"));

	}
}
