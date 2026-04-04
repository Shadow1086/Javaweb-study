package com.practice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: com.practice.pojo
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/4 20:22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysUser {
	private String uid;
	private String username;
	private String userPwd;
}
