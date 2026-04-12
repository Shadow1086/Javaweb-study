import {createRouter, createWebHistory} from "vue-router";
import Operate from "../components/Operate.vue";
import List from "../components/List.vue";

const router = createRouter({
		history: createWebHistory(),
		routes: [
			{
				path: "/operate",
				components:{
					default:Operate,
					list:List
				}
			}, {
				path: "/list",
				component: List
			}, {
				path: "/",
				component: Operate
			}
		]
	}
)

export default router;