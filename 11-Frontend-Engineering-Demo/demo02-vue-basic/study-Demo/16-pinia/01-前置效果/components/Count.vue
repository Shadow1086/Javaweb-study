<template>
    <div class="count">
        <h2>当前求和为：{{sum}}</h2>
<!--        解决用户选择的value自动变为字符：核心：转换为数字
                方法一：在option中的value前添加 ':'
                方法二：在select标签中的v-model后添加：'.number'
-->
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
//数据
let sum = ref(0); //当前求和
let value = ref(1);   //用户选择的值

function addSum(){
    sum.value+=value.value;
}
function reduceSum(){
    sum.value-=value.value;
}
</script>


<style scoped>
.count {
    background-color: skyblue;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 0 10px;
}

select,button {
    margin:0 5px;
    height: 25px;
    width: 35px;
}
</style>