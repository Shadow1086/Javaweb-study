package com.practice.dao.Impl;

import com.practice.dao.SysUserDao;
import com.practice.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Package: com.practice.dao
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 13:33
 */
@Repository
public class SysUserDaoImpl implements SysUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * @param sysUser   新增的用户信息
	 * @return          改动的行数
	 */
	@Override
	public int addSysUser(SysUser sysUser) {
		String sql = """
				insert into sys_user values (?,?,?);
				""";
		return jdbcTemplate.update(sql,sysUser.getUid(),sysUser.getUsername(),sysUser.getUserPwd());
	}

	/**
	 * @param username  用户名
	 * @return      用户
	 */
	@Override
	public SysUser findByUsername(String username) {
		String sql = """
				select * from sys_user where username = ?
				""";
		List<SysUser> queryResult = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SysUser.class), username);
		if(queryResult.size()==1){
			return queryResult.getFirst();
		}else {
//			throw new Exception("查询到多个用户");
			return null;
		}
	}

	/**
	 * @param uid   用户uid
	 * @return      返回用户
	 */
	@Override
	public SysUser findByUid(Integer uid) {
		String sql = """
				select * from sys_user where uid = ?
				""";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SysUser.class), uid);
	}
}
