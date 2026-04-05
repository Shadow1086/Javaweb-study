package com.practice;

import com.practice.config.JavaConfig;
import com.practice.dao.SysUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: com.practice
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 20:58
 */

public class JdbcTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		SysUserDao userDao = (SysUserDao) context.getBean(SysUserDao.class);
	}

	@Test
	public void testUserDao() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		SysUserDao userDao = context.getBean(SysUserDao.class);
		System.out.println(userDao.findByUid(1));
		System.out.println(userDao.findByUsername("zhangsan"));
		context.close();
	}

	@Test
	public void testScheduleDao() {

	}
}
