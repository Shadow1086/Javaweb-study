import axios from 'axios';
import {onMounted, reactive} from "vue";

export default function () {
	let dogList = reactive([
		'https://images.dog.ceo/breeds/pembroke/n02113023_6567.jpg'
	])

// 方法

	async function addDog() {
		try {
			let result = await axios.get('https://dog.ceo/api/breed/pembroke/images/random')
			dogList.push(result.data.message);
		} catch (error) {
			alert(error)
		}
	}

	//写钩子
	onMounted(() => {
		addDog();
	})
	// 向外部提供数据
	return {dogList, addDog}
}