package com.study.listener;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.study.listener
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 18:42
 */

public class MyActicationListener implements HttpSessionActivationListener {
	/**
	 * @param se the {@link HttpSessionEvent} indicating the passivation of the session
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// session对象 即将进行钝化之前 执行
	}

	/**
	 * @param se the {@link HttpSessionEvent} indicating the activation of the session
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// session对象 活化完毕之后 执行
	}
}
