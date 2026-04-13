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

	/**
	 *
	 *
	 * @param sid       要删除的日程的sid
	 * @return {@link Integer }
	 */
	@Override
	public Integer deleteSchedule(Integer sid){
		return dao.deleteBySid(sid);
	}

	/**
	 * @param uid   用户id
	 * @return      影响的行数
	 */
	@Override
	public Integer addSchedule(Integer uid) {
		return dao.addSchedule(uid);
	}

	/**
	 * @param schedule
	 * @return
	 */
	@Override
	public Integer updateSchedule(SysSchedule schedule) {
		return dao.updateSchedule(schedule);
	}

	/**
	 * @param sid   用户的sid
	 * @param uid   日程的sid
	 * @return      返回受影响的行数
	 */
	@Override
	public Integer deleteBySidAndUid(Integer sid, Integer uid) {
		return dao.deleteBySidAndUid(sid,uid);
	}
}
