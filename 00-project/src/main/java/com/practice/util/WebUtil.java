package com.practice.util;

import com.practice.common.Result;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Package: com.practice.util
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 21:11
 */

public class WebUtil {
	public static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
	}

	/**
	 * 专门用于向客户端响应JSON串的方法
	 *
	 */
	public static void writejson(HttpServletResponse resp, Result result) {

		String info = objectMapper.writeValueAsString(result);
		// 告诉客户端相应给你的是一个JSON串
		try {
			resp.setContentType("application/json;charset=UTF-8");
			resp.getWriter().write(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
