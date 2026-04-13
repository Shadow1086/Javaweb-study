package com.practice.controller;

import com.practice.common.Result;
import com.practice.common.ResultCodeEnum;
import com.practice.pojo.SysUser;
import com.practice.service.Impl.SysUserServiceImpl;
import com.practice.service.SysUserService;
import com.practice.util.PasswordUtil;
import com.practice.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.practice.controller
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 15:07
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
	private final SysUserService service = new SysUserServiceImpl();

	/**
	 * 接受用户注册请求的业务处理方法(业务接口，不是interface)
	 *
	 * @param req       请求
	 * @param resp      响应
	 */
	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受前端的JSON串，转换成User对象
		BufferedReader reader = req.getReader();
		StringBuilder buffer = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			buffer.append(line);
			line = reader.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		SysUser sysUser = mapper.readValue(buffer.toString(), SysUser.class);
		// 2. 调用服务层方法，完成注册功能
		int rows = service.regist(sysUser);

		Result<Object> result = Result.ok(null);
		if (rows < 1) {
			result = Result.build(null,ResultCodeEnum.USERNAME_USED);
		}

		WebUtil.writejson(resp,result);
	}


	/**
	 * 完成用户登录时的业务接口
	 *
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder buffer = new StringBuilder();
		String line = reader.readLine();
		while(line!=null){
			buffer.append(line);
			line=reader.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		// 用户登录的账号密码
		SysUser user = mapper.readValue(buffer.toString(), SysUser.class);
		// 数据库中查询出来的用户
		SysUser userData = service.findByUsername(user.getUsername());
		Result result = Result.ok(null);
		if (userData == null) {
			result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
		} else {
			if (PasswordUtil.matches(user.getUserPwd(), userData.getUserPwd())) {
				// 登录成功后，将登录的用户信息放入session域
				HttpSession session = req.getSession();
				session.setAttribute("sysUser", userData);

				// 登录成功，将用户的 uid 和 username 响应给客户端
				Map<String,SysUser> data = new HashMap<String,SysUser>();
				userData.setUserPwd("");
				data.put("loginUser",userData);

				result = Result.ok(data);
			} else {
				result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
			}
		}
		// 将登录结果相应给客户端
		WebUtil.writejson(resp,result);
	}

	/**
	 * 注册时，接受要注册的用户名，校验用户名是否被占用的业务接口
	 */
	protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受用户名
		String username = req.getParameter("username");
		// 判断是否被占用
		SysUser user = service.findByUsername(username);
		Result<Object> result = Result.ok(null);
		// 返回值
		if (user != null) {
			result = Result.build(null, ResultCodeEnum.USERNAME_USED);
		}
		// 将result对象转换为JSON串响应给客户端
		// ObjectMapper
		WebUtil.writejson(resp, result);
	}
}
