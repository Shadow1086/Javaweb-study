package com.practice.dao;

import com.practice.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.dao
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 20:56
 */
@Repository
public interface SysUserDao {

	int addSysUser(SysUser sysUser);

	SysUser findByUsername(String username);

	SysUser findByUid(Integer uid); // 可选，不是第一版必须


}
