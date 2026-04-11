<template>
    <div class="person">
        <h1>情况四：监视reactive定义的对象类型数据</h1>
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
import { reactive, watch } from "vue";
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
    person.car={c1:'雅迪',c2:'小刀'}
}

// 只监视姓名
watch(()=>{return person.name},(newValue,oldValue)=>{
    console.log('person的name变化了',oldValue,newValue)
})
// 直接使用属性值，如果car全部变了，那么就不会监视，也就是说car整体变了，但是监视器挂载在了原car属性上
watch(person.car,(newValue,oldValue)=>{
    console.log('person的car变化了',newValue,oldValue)
})
// 使用getter函数就会关注的是car的地址值
watch(()=>person.car,(newValue,oldValue)=>{
    console.log('person的car变化了',newValue,oldValue)
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