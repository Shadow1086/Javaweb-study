package com.study.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Package: com.study.servlet
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 14:39
 */
@WebServlet("/sa")
public class ServletA extends HttpServlet {
	/*
	* 1. 请求转发是通过HttpServletRequest对象实现的
	* 2. 请求转发是服务器内部行为，对客户端是屏蔽的
	* 3. 客户端只产生了一次请求，服务器值产生了一堆request 和response对象
	* 4. 客户端的地址栏是不变的
	* 5. 请求的参数是可以继续传递的。
	* 6. 目标资源可以使servlet动态资源，也可以使html静态资源
	* 7. 目标资源可以使WEB-INF下的受保护地资源，盖房始业式Web-INF下的资源的唯一访问方式
	* 8. 目标资源不可以是外部资源
	* */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servletA 执行了");

		// 获得请求转发器
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("sb");
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
		requestDispatcher.forward(req,resp);
	}
}
