<template>
    <div class="person">

    </div>
</template>


<script lang="ts" setup>
import {type Persons} from "@/types"

// let person: PersonInter = {id: 'daskfjk01', name: '张三', age: 40};

// 使用泛型
// let personList:Array<PersonInter> =[
//     {id: 'daskfjk01', name: '张三', age: 40},
//     {id: 'daskfjk02', name: '李四', age: 55},
//     {id: 'daskfjk03', name: '王五', age: 33}
// ]
// 在main.ts中声明一个自定义对象
let personList: Persons = [
    {id: 'daskfjk01', name: '张三', age: 40},
    {id: 'daskfjk02', name: '李四', age: 55},
    {id: 'daskfjk03', name: '王五', age: 33}
]
</script>

<style>

</style>