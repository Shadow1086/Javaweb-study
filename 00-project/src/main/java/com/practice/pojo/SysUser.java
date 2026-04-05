package com.practice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
@Component
public class SysUser {
	private Integer uid;
	private String username;
	private String userPwd;
}
