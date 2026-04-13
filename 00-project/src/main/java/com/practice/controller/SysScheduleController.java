package com.practice.controller;

import com.practice.common.Result;
import com.practice.pojo.SysSchedule;
import com.practice.pojo.SysUser;
import com.practice.pojo.vo.ScheduleListVO;
import com.practice.service.Impl.SysScheduleServiceImpl;
import com.practice.service.SysScheduleService;
import com.practice.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Package: com.practice.controller
 * Description:
 * <p>
 * 增加日程的请求      /schedule/add
 * 查询日程的请求      /schedule/find
 * 修改日程的请求      /schedule/update
 * 删除日程的请求      /schedule/remove
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 15:05
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
	private final SysScheduleService service = new SysScheduleServiceImpl();

	/**
	 * 查询用户的所有日程信息
	 *
	 * @param req  请求
	 * @param resp 响应
	 */
	protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求中的uid参数
		int uid = Integer.parseInt(req.getParameter("uid"));
		// 查询用户的所有日程
		List<SysSchedule> itemList = service.findItemListByUid(uid);
		// 将用唬得所有日程放入一个Result对象
//		Map data = new HashMap();
//		data.put("itemList",itemList);
		Result<ScheduleListVO> result = Result.ok(new ScheduleListVO(itemList));

//		Result<Map> result = Result.ok(data);

		// 将Result对象转换为JSON相应给客户端
		WebUtil.writejson(resp, result);
	}

	/**
	 * 删除用户的日程信息
	 *
	 * @param req  请求
	 * @param resp 响应
	 */
	protected void deleteScheduleBySid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		HttpSession session = req.getSession();
		SysUser user = (SysUser) session.getAttribute("sysUser");
		Integer uid = user.getUid();
		service.deleteBySidAndUid(sid, uid);
		WebUtil.writejson(resp, Result.ok(null));
	}


	protected void addSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("uid"));
		service.addSchedule(uid);

		WebUtil.writejson(resp, Result.ok(null));
	}

	protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求体中的JSON串，转换成一个sysSchedule
		BufferedReader reader = req.getReader();
		String line = reader.readLine();
		StringBuffer buffer = new StringBuffer();
		while (line != null) {
			buffer.append(line);
			line = reader.readLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		SysSchedule sysSchedule = mapper.readValue(buffer.toString(), SysSchedule.class);
		// 调用服务层处理数据
		Integer rows = service.updateSchedule(sysSchedule);
		WebUtil.writejson(resp, Result.ok(null));
	}
}
