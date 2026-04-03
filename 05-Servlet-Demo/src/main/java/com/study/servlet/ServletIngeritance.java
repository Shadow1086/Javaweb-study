package com.study.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * servlet的继承结构
 * 顶级接口：Servlet
 *
 * {@code @Create} 2025/9/27 14:19
 */
@WebServlet("/servletInger")
public class ServletIngeritance extends HttpServlet {
	public ServletIngeritance() {
	}

	@Override
	public void init() throws ServletException {

	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//	}

	@Override
	public void destroy() {

	}
}
