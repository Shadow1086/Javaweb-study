package com.study;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
@WebServlet(value = "/slc",loadOnStartup = 100)
public class ServletLifeCycle extends HttpServlet {

	public ServletLifeCycle() {
		System.out.println("构造器执行");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("初始化");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("服务");
	}

	@Override
	public void destroy() {
		System.out.println("销毁");
	}
}
