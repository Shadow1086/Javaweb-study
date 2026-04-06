package com.study.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * Package: com.study
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 18:12
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
	/**
	 * @param sce the ServletContextEvent containing the ServletContext that is being initialized
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		System.out.println(application.hashCode() + "应用域初始化了");
	}

	/**
	 * @param sce the ServletContextEvent containing the ServletContext that is being destroyed
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		System.out.println(application.hashCode() + "应用域销毁了");
	}

	/**
	 * @param event the ServletContextAttributeEvent containing the ServletContext to which the attribute was added, along
	 *              with the attribute name and value
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		ServletContext application = event.getServletContext();
		String key = event.getName();
		String value = (String) event.getValue();
		System.out.println(application.hashCode() + "应用域增加了" + key + "：" + value);
	}

	/**
	 * @param event the ServletContextAttributeEvent containing the ServletContext from which the attribute was removed,
	 *              along with the attribute name and value
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		ServletContext application = event.getServletContext();
		String key = event.getName();
		String value = (String) event.getValue();
		System.out.println(application.hashCode() + "应用域移除了" + key + "：" + value);
	}

	/**
	 * @param event the ServletContextAttributeEvent containing the ServletContext in which the attribute was replaced,
	 *              along with the attribute name and its old value
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		ServletContext application = event.getServletContext();
		String key = event.getName();
		String value = (String) event.getValue();        // 获取的是旧的值
		// 获取最新的值
		Object newValue = application.getAttribute(key);
		System.out.println(application.hashCode() + "应用域修改了" + key + "：" + value + " 为：" + newValue);
	}
}
