import {createRouter, createWebHistory} from "vue-router";

import Update from "@/component/Update.vue";
import Add from "@/component/Add.vue";
import List from "@/component/List.vue";
import ShowDetail from "../component/ShowDetail.vue";
// 导入创建路由的相关方法
const router = createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: '/showDetail/:id/:language',
			name: 'showDetail',
			component: ShowDetail,
			props: true
		},
		{
			path: "/add",
			component: Add
		},
		{
			path: "/list",
			component: List
		}, {
			path: "/update",
			component: Update
		}
	]
})
// 设置全局前置守卫
// to 上一个
router.beforeEach((to, from, next) => {
	console.log("beforeEach()方法")
	console.log(from.path + "->" + to.path);
	next();
})

// 设置全局后置守卫
router.afterEach((to, from) => {
	console.log("afterEach()方法")
	console.log(from.path + "->" + to.path);
})

export default router;