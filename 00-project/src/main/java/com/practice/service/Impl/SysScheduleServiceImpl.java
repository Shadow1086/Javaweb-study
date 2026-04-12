package com.practice.service.Impl;

import com.practice.dao.Impl.SysScheduleDaoImpl;
import com.practice.dao.SysScheduleDao;
import com.practice.pojo.SysSchedule;
import com.practice.service.SysScheduleService;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Package: com.practice.service.Impl
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/12 21:28
 */

public class SysScheduleServiceImpl implements SysScheduleService {
	private SysScheduleDao dao = new SysScheduleDaoImpl();
	/**
	 * @param uid  前端返回的要查询日程信息的用户ID
	 * @return      用户日程信息的List
	 */
	@Override
	public List<SysSchedule> findItemListByUid(Integer uid) {
		return dao.findListByUid(uid);
	}
}
