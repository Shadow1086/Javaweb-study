package com.practice.dao.Impl;

import com.practice.dao.SysScheduleDao;
import com.practice.pojo.SysSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Package: com.practice.dao.Impl
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/5 13:52
 */
@Repository
public class SysScheduleDaoImpl implements SysScheduleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 输入用户的uid获取日程信息
	 *
	 * @param uid 用户的uid
	 * @return {@link List }<{@link SysSchedule }>
	 */
	@Override
	public List<SysSchedule> findListByUid(Integer uid) {
		String sql = """
				SELECT * FROM sys_schedule WHERE uid = ?
				""";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SysSchedule.class), uid);
	}

	/**
	 * 根据日程的sid获取日程信息
	 *
	 * @param sid 日程的sid
	 * @return {@link SysSchedule }
	 */
	@Override
	public SysSchedule findBySid(Integer sid) {
		String sql = """
				SELECT * FROM sys_schedule WHERE sid = ?
				""";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SysSchedule.class), sid);

	}

	/**
	 * 根据用户的uid和日程的sid获取日程信息
	 *
	 * @param sid 日程的sid
	 * @param uid 用户的uid
	 * @return {@link SysSchedule }
	 */
	@Override
	public SysSchedule findBySidAndUid(Integer sid, Integer uid) {
		String sql = """
				SELECT * FROM sys_schedule WHERE sid = ? AND uid = ?
				""";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SysSchedule.class), sid, uid);
	}

	/**
	 * 添加日程信息
	 *
	 * @param sysSchedule 日程信息
	 * @return int
	 */
	@Override
	public int addSchedule(SysSchedule sysSchedule) {
		String sql = """
				INSERT INTO sys_schedule VALUES (?,?,?,?);
				""";
		return jdbcTemplate.update(sql, sysSchedule.getSid(), sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
	}

	/**
	 * 更新日程信息
	 *
	 * @param sysSchedule 日程信息
	 * @return int
	 */
	@Override
	public int updateSchedule(SysSchedule sysSchedule) {
		String sql = """
				UPDATE sys_schedule SET title = ?,completed = ? WHERE sid = ? AND uid = ?
				""";
		return jdbcTemplate.update(sql, sysSchedule.getTitle(), sysSchedule.getCompleted(), sysSchedule.getSid(), sysSchedule.getUid());
	}

	/**
	 * 根据日程的sid 和 用户的uid删除日程
	 *
	 * @param sid 日程的sid
	 * @param uid 用户的uid
	 * @return int
	 */
	@Override
	public int deleteBySidAndUid(Integer sid, Integer uid) {
		String sql = """
				DELETE FROM sys_schedule WHERE sid = ? AND uid = ?;
				""";
		return jdbcTemplate.update(sql, sid, uid);
	}
}
