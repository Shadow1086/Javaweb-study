//定义共享的pinia数据
import {defineStore} from "pinia";

// 定义一个Person共享
export const definedPerson = defineStore('personPinia',
	{
		state: () => {
			return {
				// 状态：就是响应式数据
				username: "zhangsan",
				age: 10,
				hobbies: ["唱歌", "跳舞"]
			}
		},
		getters: {
			// 专门定义一个获得数据或者是使用和苏剧计算结果的一些函数，这里的函数不要修改数据
			getAge(state): number {
				return state.age;
			},
			getHobbiesCount(state) {
				return state.hobbies.length;
			}
		},
		actions: {
			// 专门定义一些修改数据的函数
			doubelAge() {
				this.age = this.age * 2;
			}
		}
	}
)