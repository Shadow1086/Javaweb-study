package com.practice.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Package: com.practice.servlet
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 20:26
 */
@WebServlet("/sa")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建Cookies
		Cookie cookieA = new Cookie("keyA","valueA");
		// 设置cookies的持久化时间
		cookieA.setMaxAge(60*5);
		// 设置cookie的提交路径
		cookieA.setPath("/sb");
		Cookie cookieB = new Cookie("keyB", "valueB");
		// 将Cookies放入response对象中
		resp.addCookie(cookieA);
		resp.addCookie(cookieB);
	}
}
