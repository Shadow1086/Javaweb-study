package com.study.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Package: com.study.Request
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 13:38
 */
@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求中的参数
		// 获取键值对形式的参数
		// 根据参数名获取单个参数值
		String username = req.getParameter("username");
		System.out.println("username = " + username);
		System.out.println("userpwd = " + req.getParameter("userpwd"));

		// 根据参数名获取多个参数值
		String[] hobbies = req.getParameterValues("hobby");
		for (String hobby : hobbies) {
			System.out.println(hobby);
		}

		// 获取所有的参数名
		Enumeration<String> parameterNames = req.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String pname = parameterNames.nextElement();
			String[] values = req.getParameterValues(pname);
			if (values.length > 1) {
				System.out.println(pname + "=" + Arrays.toString(values));
			} else {
				System.out.println(pname + "=" + values[0]);
			}
		}

		//返回所有参数的map集合      key = 参数名  value = 参数值
		Map<String, String[]> parameterMap = req.getParameterMap();
		Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
		for (Map.Entry<String, String[]> entry : entries) {
			String key = entry.getKey();
			String[] value = entry.getValue();
			if (value.length > 1) {
				System.out.println(key + "=" + Arrays.toString(value));
			} else {
				System.out.println(key + "=" + value[0]);
			}
		}
		/*
		* 以上API专门用于获取key=value形式的参数，无论这些参数是在url后还是在请求体中
		* 请求：
		*       请求行     方式 uri http/1.1
		*       请求头
		*       请求体
		* form表单标签提交GET请求是，参数以键值对形式放在url后，不放在请求体里，GET方式的请求也是可以有请求体的
		* */

		// 获得请求体中的非键值对数据，比如JSON串，文件
		// 获取一个从请求体中读取字符的字符输入流
		BufferedReader reader = req.getReader();
		// 获得一个从请求体中读取二进制数据字节的输入流
		ServletInputStream inputStream = req.getInputStream();

		//
		System.out.println(req.getServletPath());

	}
}
