/*
* 专门用来存储日程状态信息的pinia
* */

import {defineStore} from "pinia";

export const definedSchedule = defineStore("scheduleList", {
	state: () => {
		return {
			itemList: [
				{
					sid: 1,
					uid: 1,
					title: '学习JAVA',
					completed: 0
				}
			]
		}
	}, getters: {

	}, actions: {

	}
})