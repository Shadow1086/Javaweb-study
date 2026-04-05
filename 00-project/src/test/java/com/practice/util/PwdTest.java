package com.practice.util;

import org.junit.jupiter.api.Test;

/**
 * Package: com.practice.util
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 15:51
 */

public class PwdTest {
	@Test
	public void test01() {
		String encode = PasswordUtil.encode("123456");
		String pwsEx = "123456";
		boolean matches = PasswordUtil.matches(pwsEx, encode);
		System.out.println(matches);
	}
}
