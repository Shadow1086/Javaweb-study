import {defineStore} from "pinia";
import axios from "axios";
import {nanoid} from "nanoid";

export const useLoveTalkStore  = defineStore('loveTalk',{
	actions:{
		async getLoveTalk(){
			let result = await axios.get('https://api.oick.cn/api/dog?apikey=2f35110e13021186394787624629e837');
			let obj = {id: nanoid(), title: result.data};
			this.talkList.unshift(obj)
		}
	},
	state(){
		return{
			talkList:JSON.parse(localStorage.getItem('talkList') as string)
		}
	}
})