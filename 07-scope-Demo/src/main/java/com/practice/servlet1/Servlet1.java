package com.practice.servlet1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.servlet1
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 14:44
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 向请求域存放数据
		req.setAttribute("request","requestMessage");
		// 向会话域存放数据
		HttpSession session = req.getSession();
		session.setAttribute("session","sessionMessage");
		// 向应用域存放数据
		ServletContext application = getServletContext();
		application.setAttribute("application","applicationMessage");

		// 获取请求域数据
		System.out.println("请求域：" + (String) req.getAttribute("request"));

		// 请求转发
//		req.getRequestDispatcher("s2").forward(req,resp);


	}
}
