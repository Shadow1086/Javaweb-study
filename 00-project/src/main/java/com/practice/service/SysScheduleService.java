package com.practice.service;

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
}
