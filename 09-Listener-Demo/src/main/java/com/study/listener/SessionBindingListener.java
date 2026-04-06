package com.study.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.study.listener
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 18:33
 */

public class SessionBindingListener implements HttpSessionBindingListener {
	/**
	 * @param event the event that identifies the session
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 当前监听器实例放入某个session中作为数据，绑定行为
	}

	/**
	 * @param event the event that identifies the session
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// 当前监听器实例从某个session中移除作为数据，解绑定
	}
}
