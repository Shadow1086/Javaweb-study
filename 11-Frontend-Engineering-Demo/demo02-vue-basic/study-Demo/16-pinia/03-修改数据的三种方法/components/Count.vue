<template>
    <div class="count">
        <h2>当前求和为：{{ countStore.sum }} </h2>
        <h2>数据一：{{ countStore.school }},数据二：{{ countStore.address }}</h2>
        <select v-model="value">
            <option :value="1">1</option>
            <option :value="2">2</option>
            <option :value="3">3</option>
        </select>
        <button @click="addSum">加</button>
        <button @click="reduceSum">减</button>
    </div>
</template>

<script lang="ts" setup>
import {ref} from "vue";
import {useCountStore} from '@/store/count';

const countStore = useCountStore();

//数据
let value = ref(1);   //用户选择的值
// 修改数据的三个方法：
// 1. 直接操作：countStore.sum += 1
// 2. 数据很多时：使用patch方法
/*
*     countStore.$patch({
        sum:888,
        school: 'newSchool',
        address: 'newAddress'
    })
* */
function addSum() {
    countStore.increment(value.value)
}

// 3. 使用actions动作：
function reduceSum() {
    countStore.decrement(value.value);
}
</script>


<style scoped>
.count {
    background-color: skyblue;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 0 10px;
}

select, button {
    margin: 0 5px;
    height: 25px;
    width: 35px;
}
</style>