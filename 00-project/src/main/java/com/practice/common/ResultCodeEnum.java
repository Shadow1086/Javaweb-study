package com.practice.common;

/**
 * Package: com.practice.common
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/6 20:38
 */
public enum ResultCodeEnum {
	SUCCESS(200,"success"),
	USERNAME_ERROR(501,"usernameError"),
	PASSWORD_ERROR(503,"passwordError"),
	NOTLOGIN(504,"notlogin"),
	USERNAME_USED(505,"usernameUsed");

	private Integer code;
	private String message;
	private ResultCodeEnum(Integer code,String message){
		this.code = code;
		this.message  = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
