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
@WebServlet("/sb")
public class Servlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求中携带的cookie
		Cookie[] cookies = req.getCookies();
		// 请求中的多个cookies会进入该数组，请求中如果没有cookie,cookies数组为：null
		if(null!= cookies){
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + "=" + cookie.getValue());
			}
		}
	}
}
