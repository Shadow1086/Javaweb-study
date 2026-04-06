package com.practice.session;

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
 * Package: com.practice.session
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 12:49
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求中的username参数
		String username = req.getParameter("username");
		// 获得session对象
		HttpSession session = req.getSession();
		// 判断请求中有没有一个特殊的cookie，称为：JSESSIONID    值 *** ***
			// 有
				// 根据JSESSIONID找对应的session对象
			// 没有，创建一个新的session返回，并且想response对象中存放一个JSESSIONID的cookie
		System.out.println(session.getId());
		System.out.println(session.isNew());
		// 将username存入session
		session.setAttribute("username",username);
		// 客户端响应信息
		resp.setContentType("text/html;charset= UTF-8");
		resp.getWriter().write("成功");
	}
}
