package com.study;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
//@WebServlet(
//		urlPatterns = "/servlet1",
//		initParams = {@WebInitParam(name = "keya", value = "vluea"), @WebInitParam(name = "keyb", value = "valueb")}
//)
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----------------------------------ServletConfig获取参数----------------------------------------");
		ServletConfig servletConfig = this.getServletConfig();
		// 获取初始配置信息即可
		// 根据参数名获取参数值
		String keya = servletConfig.getInitParameter("keya");
		System.out.println("keya = " + keya);

		// 获取所有初始参数的名字，早期的遍历器
		// hasMoreElement()：判断有没有下一个参数，如果有返回true,如果没有返回false
		// nextElement()：取出下一个元素，向下移动游标(指针)

		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String keyName = initParameterNames.nextElement();
			System.out.println("keyName = " + keyName + "\t value = " + getInitParameter(keyName));
		}
		System.out.println("----------------------------------ServletContext获取参数----------------------------------------");
		// 获取ServletContext对象,三种方式，前两者的本质是都是通过config对象获取，在内存上都是同一个
		ServletContext servletContext = getServletContext();
		ServletContext servletContext1 = servletConfig.getServletContext();
		ServletContext servletContext2 = req.getServletContext();

		// 获取参数
		String encoding = servletContext.getInitParameter("encoding");
		System.out.println("encoding = " + encoding);
		Enumeration<String> initParameterNames1 = servletContext.getInitParameterNames();

		while (initParameterNames1.hasMoreElements()) {
			String nextElement = initParameterNames1.nextElement();
			System.out.println("keyName = " + nextElement + "\tvalue = " + servletContext.getInitParameter(nextElement));
		}
	}
}
