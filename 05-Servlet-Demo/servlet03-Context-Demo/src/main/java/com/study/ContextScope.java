package com.study;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

@WebServlet("/scope")
public class ContextScope extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 作为域对象，一定会有的API
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("keya","valuea");           // 存储数据
		servletContext.setAttribute("keya","valueaaa");         // 修改数据：替换掉上面的valuea这个值

		Object keya = servletContext.getAttribute("keya");// 获取数据

		servletContext.removeAttribute("keya");
	}
}
