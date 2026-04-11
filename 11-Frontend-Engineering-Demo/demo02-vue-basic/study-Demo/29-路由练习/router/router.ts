import {createRouter, createWebHistory} from "vue-router";
import Home from "@/component/Home.vue";
import Login from "@/component/Login.vue";

const router = createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: "/login",
			name: 'login',
			component: Login
		}, {
			path: "/",
			name: "home",
			component: Home
		}
	]
})

router.beforeEach((to,_from,next)=>{
	if(to.path=='/login'){
		next();
	}else {
		if(sessionStorage.getItem("username")===null){
			router.push("login");
		}else{
			next();
		}
	}
})

export default router;