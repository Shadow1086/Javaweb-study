//package com.practice.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.util.Scanner;
//import java.util.Arrays;
//
///**
// * Package: com.practice.config
// * Description:
// * <p>
// * {@code @Author} Liang-ht
// * {@code @Create} 2026-2026/4/4 20:29
// */
//@ComponentScan("com.practice")
//@PropertySource(value = "classpath:jdbc.properties")
//@Configuration
//public class JavaConfig {
//	@Value("${practice.url}")
//	private String url;
//	@Value("${practice.driver}")
//	private String driver;
//	@Value("${practice.username}")
//	private String username;
//	@Value("${practice.password}")
//	private String password;
//	@Bean
//	public DataSource dataSource(){
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl(url);
//		dataSource.setDriverClassName(driver);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		return dataSource;
//	}
//	@Bean
//	public JdbcTemplate jdbcTemplate(){
//		return new JdbcTemplate(dataSource());
//	}
//
//}
