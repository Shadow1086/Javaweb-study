/*
* 专门用来存储用户状态信息的pinia
* */

import {defineStore} from "pinia";

interface UserState {
	uid: number,
	username: string
}

export const definedUser = defineStore('userStore', {
	state: (): UserState => ({
		uid: 0,
		username: ""
	}),
	getters: {},
	actions: {}
})
