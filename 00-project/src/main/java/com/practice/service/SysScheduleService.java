package com.practice.service;

import com.practice.controller.SysScheduleController;
import com.practice.pojo.SysSchedule;

import java.util.HashMap;
import java.util.List;

/**
 * Package: com.practice.service
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/12 21:18
 */
public interface SysScheduleService {
	List<SysSchedule> findItemListByUid(Integer uid);


	Integer addSchedule(Integer uid);

	Integer updateSchedule(SysSchedule schedule);

//	SysSchedule findItemBySid(Integer sid);

	Integer deleteBySidAndUid(Integer sid, Integer uid);

	Integer deleteSchedule(Integer sid);
}
