<template>
	<div class="person">
		<h2>一辆{{ car.brand }}车，价值{{ car.price }}万</h2>
		<button @click="changePrice">修改汽车价格</button>
        <button @click="changeName">修改汽车品牌</button>
        <button @click="changeCar">修改汽车</button>
		<br>
		<h2>游戏列表：</h2>
		<ul>
			<li v-for="game in games" :key="game.id">{{ game.name }}</li>
		</ul>
		<button @click="changeFirstGame">修改第一个游戏名称</button>
	</div>
</template>

<script lang="ts" name="Person" setup>
import {ref} from 'vue'
//数据
let car = ref({brand: '奔驰', price: 100});
let games = ref([
	{id: 'asdfjklasdf01', name: '王者'},
	{id: 'asdfjklasdf02', name: '和平'},
	{id: 'asdfjklasdf03', name: '吃鸡'}
])

//方法
function changePrice() {
	car.value.price += 10;
}
function changeName() {
	car.value.brand = '宝马';
}

function changeFirstGame() {
	games.value[0].name='原神';
}

function changeCar(){
    //当使用reactive定义对象时，就需要如下的方式来替换整个对象
    // Object.assign(car,{brand:'奥拓',price:1});
    //当使用ref定义时：
    car.value={brand: '奥拓',price: 2};
}

</script>

<style scoped>
.person {
	background-color: skyblue;
	box-shadow: 0 0 10px;
	border-radius: 10px;
	padding: 20px;
}

li {
	font-size: 20px;
}

</style>