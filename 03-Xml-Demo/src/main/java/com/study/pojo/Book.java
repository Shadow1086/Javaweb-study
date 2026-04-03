package com.study.pojo;

import lombok.Data;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
@Data
public class Book {
	private String sn;
	private String name;
	private double price;
	private String author;

	public Book(String sn, String name, double price, String author) {
		this.sn = sn;
		this.name = name;
		this.price = price;
		this.author = author;
	}
}
