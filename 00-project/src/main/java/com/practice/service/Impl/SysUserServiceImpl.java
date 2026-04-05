package com.practice.service.Impl;

import com.practice.dao.SysUserDao;
import com.practice.pojo.SysUser;
import com.practice.service.SysUserService;
import com.practice.util.PasswordUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Package: com.practice.service.Impl
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 14:45
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	@Resource(name = "sysUserDao")
	private SysUserDao dao;

	/**
	 * 用户注册
	 *
	 * @param sysUser 用户
	 * @return int
	 */
	@Override
	public int regist(SysUser sysUser) {
		return dao.addSysUser(sysUser);
	}

	/**
	 * 用户登录
	 *
	 * @param username 用户名
	 * @param userPwd  密码
	 * @return {@link SysUser } 返回null证明登录失败，返回用户说明登录成功
	 */
	@Override
	public SysUser login(String username, String userPwd) {
		SysUser user = dao.findByUsername(username);
		String encodePwd = PasswordUtil.encode(user.getUserPwd());
		if (PasswordUtil.matches(encodePwd, userPwd)) {
			return user;
		} else {
			return null;
		}

	}

	/**
	 * 根据用户名查找用户
	 *
	 * @param username 用户名
	 * @return {@link SysUser }
	 */
	@Override
	public SysUser findByUsername(String username) {
		return dao.findByUsername(username);
	}
}
