package com.practice.controller;

import com.practice.pojo.SysUser;
import com.practice.service.Impl.SysUserServiceImpl;
import com.practice.service.SysUserService;
import com.practice.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
		// 1, 接受客户端提交的参数
		String username = req.getParameter("username");
		String password = req.getParameter("user-pwd");
		String passwordCon = req.getParameter("user-conpwd");
		// 将参数放入一个SysUser对象中，在调用方法传入
		if (!passwordCon.equals(password)) {
			resp.sendRedirect("/registerFail.html");
			return;
		}
		SysUser user = new SysUser(null, username, password);
		// 2. 调用服务层方法，完成注册功能
		int rows = service.regist(user);
		if (rows > 0) {
			resp.sendRedirect("/registerSuccess.html");
		} else {
			resp.sendRedirect("/registerFail.html");
		}
		// 3. 根据注册结果，做页面跳转
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
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		SysUser userData = service.findByUsername(username);
		if (userData == null) {
			resp.sendRedirect("/loginUserError.html");
		} else {
			SysUser user = new SysUser(null, username, password);
			if(PasswordUtil.matches(password,userData.getUserPwd())){
				// 登录成功，用户名密码正确
				resp.sendRedirect("/showSchedule.html");
			}else {
				resp.sendRedirect("/loginUserPwdError.html");
			}
		}

	}
}
