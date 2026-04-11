<template>
    <div class="count">
        <h2>当前求和为：{{ sum }} </h2>
        <h2>数据一：{{ school }},数据二：{{ address }}</h2>
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
import {storeToRefs} from "pinia";

const countStore = useCountStore();

const {sum,school,address} = storeToRefs(countStore);
// storeToRefs 只关注store中的数据，不会对方法进行ref包裹

//数据
let value = ref(1);   //用户选择的值
function addSum() {
    countStore.increment(value.value)
}
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