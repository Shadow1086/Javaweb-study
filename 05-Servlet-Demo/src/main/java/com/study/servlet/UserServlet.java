package com.study.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 从request对象中获取请求中的任何信息(如：username参数)
		String username = request.getParameter("username");//根据惨书名获取参数值，无论参数是在url?后还是在请求体中

		// 2. 处理业务的代码
		String info = "<h1>YES</h1>";
		if ("atguigu".equals(username)) {
			info = "NO";
		}
		// 3. 将要响应的数据放到response中
		// 应该设置Content-type响应头,如果设置错了，浏览器就不会识别相应的格式
		// 方法：setHeader("Content-Type","Value")/setContentType("Value");
		response.setHeader("Content-Type","text/html");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();//该方法返回的是一个向相应体中打印字符串的打印流
		writer.write(info);

	}
}
