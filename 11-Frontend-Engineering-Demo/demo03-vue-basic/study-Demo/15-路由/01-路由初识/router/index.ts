// 创建一个路由器，并暴露出去


// 创建路由器
import {createRouter, createWebHistory} from "vue-router";

// 引入一个个可能要呈现的组件
import Home from '@/components/Home.vue'
import News from "@/components/News.vue";
import About from "@/components/About.vue";

const router = createRouter({
	history:createWebHistory(), //路由器的工作模式
	routes:[
		{
			path:'/home',
			component:Home
		},
		{
			path:'/news',
			component:News
		},
		{
			path:'/about',
			component:About
		}
	]
})
//暴露出去router
export default router