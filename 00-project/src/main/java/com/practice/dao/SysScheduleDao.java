package com.practice.dao;

import com.practice.pojo.SysSchedule;

import java.util.List;

/**
 * Package: com.practice.dao
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 13:37
 */
public interface SysScheduleDao {

	/**
	 *  添加日程信息
	 *
	 * @param sysSchedule   日程信息
	 * @return int
	 */
	int addSchedule(SysSchedule sysSchedule);

	/**
	 *  输入用户的uid获取日程信息
	 *
	 * @param uid       用户的uid
	 * @return {@link List }<{@link SysSchedule }>
	 */
	List<SysSchedule> findListByUid(Integer uid);

	/**
	 *  根据日程的sid获取日程信息
	 *
	 * @param sid       日程的sid
	 * @return {@link SysSchedule }
	 */
	SysSchedule findBySid(Integer sid);

	/**
	 *  根据用户的uid和日程的sid获取日程信息
	 *
	 * @param sid   日程的sid
	 * @param uid   用户的uid
	 * @return {@link SysSchedule }
	 */
	SysSchedule findBySidAndUid(Integer sid, Integer uid);


	/**
	 *  更新日程信息
	 *
	 * @param sysSchedule   日程信息
	 * @return int
	 */
	int updateSchedule(SysSchedule sysSchedule);

	/**
	 *  根据日程的sid 和 用户的uid删除日程
	 *
	 * @param sid   日程的sid
	 * @param uid   用户的uid
	 * @return int
	 */
	int deleteBySidAndUid(Integer sid, Integer uid);

}
