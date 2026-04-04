package com.study.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Package: com.study.response
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 14:15
 */
@WebServlet("/s5")
public class Servlet5 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置相应行相关的API  http/1.1  200/404/405...    状态描述
		resp.setStatus(200);
		String info = "<h1>hello</h1>";
		// 设置响应头相关的API
		resp.setHeader("aaa","valuea");
		resp.setHeader("Content-Type","text/html");
		resp.setContentType("text/html");
		resp.setContentLength(info.getBytes().length);

		// 设置响应体内容API
		// 获得一个向响应体中输入文本字符输出流
		PrintWriter writer = resp.getWriter();
		writer.write(info);
		// 获得一个系哪个响应体中输入二进制信息的字节输出流
		ServletOutputStream outputStream = resp.getOutputStream();
	}
}
