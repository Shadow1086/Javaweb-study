package com.practice.service;

import com.practice.pojo.SysUser;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.service
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 13:37
 */

public interface SysUserService {

	/**
	 *  用户注册
	 *
	 * @param sysUser   用户
	 * @return int
	 */
	int regist(SysUser sysUser);

	/**
	 *  用户登录
	 *
	 * @param username  用户名
	 * @param userPwd   密码
	 * @return {@link SysUser }
	 */
	SysUser login(String username, String userPwd);

	/**
	 *  根据用户名查找用户
	 *
	 * @param username  用户名
	 * @return {@link SysUser }
	 */
	SysUser findByUsername(String username); // 可选

}
