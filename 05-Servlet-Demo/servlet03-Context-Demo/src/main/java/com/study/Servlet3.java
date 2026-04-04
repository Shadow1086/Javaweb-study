package com.study;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();

		// 向upload目录中写入一个文件
		// 1. getRealPath()：获得一个只想项目部署位置下的某个文件/目录的磁盘真是路径的API
		String path = servletContext.getRealPath("upload");
		System.out.println(path);

		// 2.获取项目部署的上下文路径，即项目的访问路径
		// 后续我们会学习在项目中使用相对和绝对路径赵目标资源
		// getContextPath()：获取项目的上下文路径，项目的访问路径
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath);
	}
}
