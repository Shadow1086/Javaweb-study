package com.practice.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Package: com.practice.util
 * Description:
 * <p>
 * 密码工具类
 * 使用BCrypt对密码进行哈希和校验
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 15:42
 */
@Component
public class PasswordUtil {

	private static final int STRNGTH = 7;
	private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(STRNGTH);

	private PasswordUtil() {
	}

	/**
	 * 对明文密码进行哈希加密
	 *
	 * @param password 明文密码
	 * @return {@link String }  返回哈希后的密码
	 */
	public static String encode(String password) {
		if (password == null || password.isBlank()) {
			throw new IllegalArgumentException("密码不能为空");
		}
		return ENCODER.encode(password);
	}

	/**
	 * 检验明文密码和哈希密码是否匹配
	 *
	 * @param password   明文密码
	 * @param encodedPwd 数据库中的哈希密码
	 * @return boolean  true表示匹配，false表示不匹配
	 */
	public static boolean matches(String password, String encodedPwd) {
		if (password == null || password.isBlank()) {
			return false;
		}
		if (encodedPwd == null || encodedPwd.isBlank()) {
			return false;
		}
		return ENCODER.matches(password, encodedPwd);
	}
}
