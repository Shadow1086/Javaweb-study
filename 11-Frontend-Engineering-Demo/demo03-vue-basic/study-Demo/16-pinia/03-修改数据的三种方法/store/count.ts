import {defineStore} from 'pinia';

export const useCountStore = defineStore('count', {
	// actions里面放置的是一个个的动作函数
	actions: {
		increment(value:number) {
			this.sum += value;
		},
		decrement(value:number){
			if(this.sum <= 0){
				alert('sum值不能小于0')
			}else{
				this.sum -= value;
			}
		}
	},
	state() {
		return {
			sum: 6,
			school: 'hello',
			address: 'helloAddress'
		}
	}
})