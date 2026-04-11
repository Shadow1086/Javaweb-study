<template>
    <div class="person">
        <h2>一辆{{ car.brand }}车，价值{{ car.price }}万</h2>
        <button @click="changePrice">修改汽车价格</button>
        <br>
        <h2>游戏列表：</h2>
        <ul>
            <li v-for="game in games" :key="game.id">{{ game.name }}</li>
        </ul>
        <button @click="changeFirstGame">修改第一个游戏名称</button>
        <hr>
        <div>测试数据：{{ obj.a.b.c }}</div>
        <button @click="changeTestNum">修改测试数据</button>
    </div>
</template>

<script lang="ts" name="Person" setup>
import {reactive} from 'vue'
//数据
let car = reactive({brand: '奔驰', price: 100});
let games = reactive([
    {id: 'asdfjklasdf01', name: '王者'},
    {id: 'asdfjklasdf02', name: '和平'},
    {id: 'asdfjklasdf03', name: '吃鸡'}
])
let obj = reactive({
    a: {
        b: {c: 666}
    }
})
console.log(obj);
// console.log(car);
//方法
function changePrice() {
    car.price += 10;
}

function changeFirstGame() {
    games[0].name = '原神';
}

function changeTestNum() {
    obj.a.b.c = 888;
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