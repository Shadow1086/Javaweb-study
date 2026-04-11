<script lang="ts" name="App" setup>
import {computed} from "vue";

let msg = "hello vue 3"
let getMsg = () => {
    return "hello vue3 message";
}
let age = 17;
let bee = "蜜 蜂";
let carts = [{name: "可乐", price: 3, number: 10}, {name: "薯片", price: 5, number: 8}];
// 定义一个获取购物车商品总金额的一个方法
let compute = () => {
    let count = 0;
    for (let index in carts) {
        count += carts[index].price;
        index++;
    }
    return count;
}
</script>

<template>
    <div>
        {{ msg }} 的值为：{{ getMsg() }}
        年龄：{{ age }},是否成年:{{ age >= 18 ? '是' : '否' }}
        <br>
        {{ bee }}
        <br>
        {{ bee.split(" ").reverse().join('') }}
        <br>
        {{ compute() }}
    </div>
</template>


<style scoped>

</style>