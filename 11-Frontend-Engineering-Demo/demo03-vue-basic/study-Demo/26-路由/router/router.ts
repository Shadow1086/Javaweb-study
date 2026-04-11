import {createRouter, createWebHistory} from "vue-router";

import Update from "@/component/Update.vue";
import Add from "@/component/Add.vue";
import List from "@/component/List.vue";

const router = createRouter({
	history: createWebHistory(),
	routes: [{
		path: '/update',
		components:{
			default:Update,
			updateView:Update
		}
	}, {
		path: '/add',
		components:{
			addView:Add
		}
	}, {
		path: '/list',
		component: {
			listView:List
		}
	}, {
		path: "/showAll",
		// 重定向路由
		redirect: "/list"
	}]
})
export default router;