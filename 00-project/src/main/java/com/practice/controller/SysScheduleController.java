package com.practice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Package: com.practice.controller
 * Description:
 *
 * 增加日程的请求      /schedule/add
 * 查询日程的请求      /schedule/find
 * 修改日程的请求      /schedule/update
 * 删除日程的请求      /schedule/remove
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 15:05
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController{

}
