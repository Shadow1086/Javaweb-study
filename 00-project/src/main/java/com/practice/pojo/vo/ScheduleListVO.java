package com.practice.pojo.vo;

import com.practice.pojo.SysSchedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Package: com.practice.pojo.vo
 * Description:
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2026-2026/4/13 21:59
 */
@AllArgsConstructor
@Data
public class ScheduleListVO {
	private List<SysSchedule> itemList;

//	public ScheduleListVO(List<SysSchedule> itemList){
//		this.itemList = itemList;
//	}
//
//	public List<SysSchedule> getItemList() {
//		return itemList;
//	}
//
//	public void setItemList(List<SysSchedule> itemList) {
//		this.itemList = itemList;
//	}
}
