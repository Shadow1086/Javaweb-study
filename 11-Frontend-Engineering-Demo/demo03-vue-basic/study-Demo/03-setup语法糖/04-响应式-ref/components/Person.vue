<template>
    <div class="person">
        <h2>姓名：{{ name }}</h2>
        <h2>年龄：{{ age }}</h2>
        <button @click="changeName">修改名字</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="showTel">查看联系方式</button>

    </div>
</template>

<script lang="ts" name="Person" setup>
import {ref} from 'vue'

// 数据 ----- 注意：此时的数据不是响应式的
let name = ref("zhangsan")
let age = ref(18)
let tel = '13888888888'

//方法,setup函数中的this是undefined
function changeName() {
    name.value = '张三'     //这样修改，页面没有变化，但确实修改了
}

function changeAge() {
    age.value++
}

function showTel() {
    alert(tel)
}

</script>

<style scoped>
.person {
    background-color: skyblue;
    box-shadow: 0 0 10px;
    border-radius: 10px;
    padding: 20px;
}
</style>