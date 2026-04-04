package com.practice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.pojo
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 20:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSchedule {
	private Integer sid;
	private Integer uid;
	private String title;
	private Integer completed;
}
