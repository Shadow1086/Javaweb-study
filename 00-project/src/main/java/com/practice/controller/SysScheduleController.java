package com.practice.controller;

import com.practice.common.Result;
import com.practice.pojo.SysSchedule;
import com.practice.service.Impl.SysScheduleServiceImpl;
import com.practice.service.SysScheduleService;
import com.practice.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private SysScheduleService service = new SysScheduleServiceImpl() ;
	protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求中的uid参数
		int uid = Integer.parseInt(req.getParameter("uid"));
		// 查询用户的所有日程
		List<SysSchedule> itemList = service.findItemListByUid(uid);
		// 将用唬得所有日程放入一个Result对象
		Map data = new HashMap();
		data.put("itemList",itemList);

		Result<Map> result = Result.ok(data);
		// 将Result对象转换为JSON相应给客户端
		WebUtil.writejson(resp,result);
	}
}
