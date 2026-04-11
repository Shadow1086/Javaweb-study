import {createRouter, createWebHistory} from "vue-router";

import Update from "@/component/Update.vue";
import Add from "@/component/Add.vue";
import List from "@/component/List.vue";
// 导入创建路由的相关方法
const router = createRouter({
	history:createWebHistory(),
	routes:[
		{
			path:"/add",
			component:Add
		},
		{
			path:"/list",
			component:List
		},{
		path:"/update",
			component:Update
		}
	]
})

export default router;