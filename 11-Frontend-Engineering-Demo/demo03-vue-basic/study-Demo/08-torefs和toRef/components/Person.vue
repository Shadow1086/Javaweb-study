<template>
    <div class="person">
        <h2>姓名：{{ person.name }}</h2>
        <h2>年龄：{{ person.age}} , {{age}}</h2>
        <button @click="changeName">修改姓名</button>
        <button @click="changeAge">修改年龄</button>
    </div>
</template>

<script lang="ts" name="Person" setup>
import {reactive, toRef, toRefs} from 'vue'

let person = reactive({name: '张三', age: 18})

let {name, age} = toRefs(person);
let nl = toRef(person,'age');

console.log(nl);

function changeName() {
    name.value = '李四'
}

function changeAge() {
    age.value = 30;
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