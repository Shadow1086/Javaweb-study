import {onMounted, ref,computed} from "vue";


export default function () {
	let sum = ref(0)
	let bigSum = computed(()=>{
		return sum.value *10;
	})

// 方法
	function add() {
		sum.value++;
	}

	// 钩子
	onMounted(() => {
		sum.value += 20;
	})
	return {sum, add,bigSum}
}
