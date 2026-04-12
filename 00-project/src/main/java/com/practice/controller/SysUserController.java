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
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受前端的JSON串，转换成User对象
		BufferedReader reader = req.getReader();
		StringBuffer buffer = new StringBuffer();
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

		// 3. 根据注册结果，做页面跳转


//		// 1, 接受客户端提交的参数
//		String username = req.getParameter("username");
//		String password = req.getParameter("user-pwd");
//		String passwordCon = req.getParameter("user-conpwd");
//		// 将参数放入一个SysUser对象中，在调用方法传入
//		if (!passwordCon.equals(password)) {
//			resp.sendRedirect("/registerFail.html");
//			return;
//		}
//		SysUser user = new SysUser(null, username, password);
		//		if (rows > 0) {
//			resp.sendRedirect("/registerSuccess.html");
//		} else {
//			resp.sendRedirect("/registerFail.html");
//		}

	}


	/**
	 * 完成用户登录时的业务接口
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		SysUser userData = service.findByUsername(username);
		BufferedReader reader = req.getReader();
		StringBuffer buffer = new StringBuffer();
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
//			resp.sendRedirect("/loginUserError.html");
		} else {
			if (PasswordUtil.matches(user.getUserPwd(), userData.getUserPwd())) {
//				// 登录成功后，将登录的用户信息放入session域
//				HttpSession session = req.getSession();
//				session.setAttribute("sysUser", userData);

				// 登录成功，将用户的uid和username响应给客户端
				Map data = new HashMap();
				userData.setUserPwd("");
				data.put("loginUser",userData);

				result = Result.ok(data);
//				// 登录成功，用户名密码正确
//				resp.sendRedirect("/showSchedule.html");
			} else {
				result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
//				resp.sendRedirect("/loginUserPwdError.html");
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
