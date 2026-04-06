package com.practice.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Package: com.practice.session
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 12:49
 */
@WebServlet("/s2")
public class Servlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得session对象
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(120);//最大存活时间：秒
		System.out.println(session.getId());
		System.out.println(session.isNew());
		// 读取session中存储的用户名
		String username = (String) session.getAttribute("username");

		System.out.println("servlet2 got username:" + username);

	}
}
