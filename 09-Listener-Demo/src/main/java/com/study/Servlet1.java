package com.study;

import com.study.listener.MyActicationListener;
import com.study.listener.SessionBindingListener;
import jakarta.servlet.ServletContext;
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
 * Package: com.study
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 18:09
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 向应用域中放入数据
		ServletContext application = req.getServletContext();
		application.setAttribute("keyA","valueA");
		//修改应用域中的数据
		application.setAttribute("keyA","valueB");
		// 删除应用域中的数据
		application.removeAttribute("keyA");

		HttpSession session = req.getSession();

		SessionBindingListener sbl = new SessionBindingListener();
		session.setAttribute("sbl",sbl);
		session.removeAttribute("sbl");

		MyActicationListener myActicationListener = new MyActicationListener();
		session.setAttribute("lis",myActicationListener);

		// 手动销毁session
		session.invalidate();
	}
}
