/*
* 专门用来存储日程状态信息的pinia
* */

import {defineStore} from "pinia";

interface ScheduleItem {
	sid: number,
	uid: number,
	title: string,
	completed: 0 | 1
}

interface ScheduleState {
	itemList: ScheduleItem[]
}

export const definedSchedule = defineStore("scheduleList", {
	state: (): ScheduleState => ({
		itemList:[]
	}), getters: {}, actions: {}
})