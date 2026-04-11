<template>
    <div class="person">
        <h1>情况五：监听上述多个数据类型</h1>
        <h2>姓名：{{ person.name }}</h2>
        <h2>年龄：{{ person.age }}</h2>
        <h2>汽车:{{ person.car.c1 }},{{ person.car.c2 }}</h2>
        <button @click="changeName">修改姓名</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="changeCar1">修改第一台车</button>
        <button @click="changeCar2">修改第二台车</button>
        <button @click="changeCarAll">修改全部车</button>
    </div>
</template>


<script lang="ts" name="Person" setup>
import {reactive, watch} from "vue";

let person = reactive({
    name: '张三',
    age: 18,
    car: {
        c1: '奔驰',
        c2: '宝马'
    }
})

function changeName() {
    person.name += '~';
}

function changeAge() {
    person.age++;
}

function changeCar1() {
    person.car.c1 = '奥迪'
}

function changeCar2() {
    person.car.c2 = '比亚迪'
}

function changeCarAll() {
    person.car = {c1: '雅迪', c2: '小刀'}
}

// 需求：监视人的姓名和第一台车
// 使用数组，数组中使用多个getter函数，那么newValue/oldValue就是你规定的数组
watch([() => person.name, () => person.car.c1], (newValue, oldValue) => {
    console.log('person的姓名或第一台车变化了..', newValue, oldValue)
})

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