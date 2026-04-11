import {createRouter, createWebHistory} from "vue-router";
import Register from "../component/Register.vue";
import Login from "../component/Login.vue";
import ShowSchedule from "../component/ShowSchedule.vue";
import Header from "../component/Header.vue";

const router = createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: "/register",
			name: "register",
			component: Register
		}, {

			path: "/",
			name: "login",
			component: Login
		},{
		path:"/showSchedule",
			name:"showSchedule",
			component:ShowSchedule
		},{
		path:"/header",
			name:"header",
			component:Header
		}
	]

})
export default router;