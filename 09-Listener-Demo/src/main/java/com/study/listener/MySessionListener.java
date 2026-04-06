package com.study.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

/**
 * Package: com.study
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 18:21
 */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * @param se the HttpSessionEvent containing the session
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 任何一个Session域对象的创建都会触发该方法的执行
		HttpSession session = se.getSession();
		System.out.println(session.hashCode() + "会话域初始化了");
	}

	/**
	 * @param se the HttpSessionEvent containing the session
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.hashCode() + "会话域销毁了");
	}

	/**
	 * @param event the HttpSessionBindingEvent containing the session and the name and value of the attribute that was
	 *              added
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();

	}

	/**
	 * @param event the HttpSessionBindingEvent containing the session and the name and value of the attribute that was
	 *              removed
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	/**
	 * @param event the HttpSessionBindingEvent containing the session and the name and (old) value of the attribute that
	 *              was replaced
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}


}
