import {defineStore} from "pinia";

export const useLoveTalkStore  = defineStore('loveTalk',{
	state(){
		return{
			talkList:[
				{id: 'ahsdif01', title: '今天你有点怪，哪里怪？怪好看的！'},
				{id: 'ahsdif02', title: '“你是不是作弊了？”“那为什么你在我心里总是满分？”'},
				{id: 'ahsdif03', title: '“我想买一块地。”“什么地？”“你的死心塌地。”'},
				{id: 'ahsdif04', title: '“我有个秘密，需要嘴对嘴告诉你的。”'},
				{id: 'ahsdif05', title: '“你以后走路能不能看着点啊。”“非要撞在我心上！”'}
			]
		}
	}
})