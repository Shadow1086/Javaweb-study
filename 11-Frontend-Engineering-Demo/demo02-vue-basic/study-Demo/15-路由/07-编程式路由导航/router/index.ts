// 创建一个路由器，并暴露出去

// 创建路由器
import {createRouter, createWebHistory} from "vue-router";

// 引入一个个可能要呈现的组件
import Home from '@/components/Home.vue'
import News from "@/components/News.vue";
import About from "@/components/About.vue";
import Detail from "@/components/Detail.vue";

const router = createRouter({
	history: createWebHistory(), //路由器的工作模式
	routes: [
		{
			name: 'zhuye',
			path: '/home',
			component: Home
		},
		{
			name: 'xinwen',
			path: '/news',
			component: News,
			children: [
				{
					name: 'newsDetail',
					path: '/detail/:id/:title/:content',
					component: Detail,
					// 第一种：将路由收到的所有params参数作为props传入路由组件
					// props:true

					// 第二种：函数写法，可以自己就决定将什么作为props给路由组件,使用场景：使用query时
					// 	props(route){
					// 		return {
					// 			route.query
					// 		}
					// 	}
					// }

					//第三种：对象写法，可以自己就决定讲什么作为路由组件,只能传递固定值！
					props: {
						a: 100,
						b: 200,
						c: 300
					}
				}
			]
		},
		{
			name: 'guanyu',
			path: '/about',
			component: About
		}
	]
})
//暴露出去router
export default router