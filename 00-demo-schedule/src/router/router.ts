import {createRouter, createWebHistory} from "vue-router";
import Register from "../component/Register.vue";
import Login from "../component/Login.vue";
import ShowSchedule from "../component/ShowSchedule.vue";

import pinia from '../pinpa.ts'
import {definedUser} from "../store/userStore.ts";

let sysUser = definedUser(pinia);

const router = createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: "/register",
			name: "register",
			component: Register
		}, {

			path: "/login",
			name: "login",
			component: Login
		}, {
			path: "/showSchedule",
			name: "showSchedule",
			component: ShowSchedule
		}, {
			path: '/',
			component: Login
		}
	]
})

router.beforeEach((to, _from, next) => {
	if (to.path === "showSchedule" || to.path === "/showSchedule") {
		if (sysUser.username === "") {
			next('login');
		} else {
			next();
		}
	} else {
		next();
	}
})
export default router;