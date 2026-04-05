package com.practice.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.util
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 18:06
 */

public class DBUtil {
	private static final JdbcTemplate JDBC_TEMPLATE;

	static{
		try {
			Properties props = new Properties();
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			props.load(is);
			DruidDataSource dataSource = new DruidDataSource();
			dataSource.setPassword(props.getProperty("practice.password"));
			dataSource.setDriverClassName(props.getProperty("practice.driver"));
			dataSource.setUsername(props.getProperty("practice.username"));
			dataSource.setUrl(props.getProperty("practice.url"));
			JDBC_TEMPLATE = new JdbcTemplate(dataSource);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static JdbcTemplate getJdbcTemplate(){
		return JDBC_TEMPLATE;
	}

}
