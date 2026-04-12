/*
* 专门用来存储用户状态信息的pinia
* */

import {defineStore} from "pinia";

export const definedUser = defineStore('userStore', {
	state: () => {
		return {
			uid:0,
			username:""
		}
	},
	getters:{

	},
	actions:{

	}
})
