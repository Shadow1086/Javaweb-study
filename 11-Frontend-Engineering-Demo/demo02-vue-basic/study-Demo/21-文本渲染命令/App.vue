<script lang="ts" name="App" setup>
/*
* 文本渲染
*   v-text
*   v-html
* */
let msg = "hello vue3"
let haha = "haha";
let msg2 = `hello ${haha}`

let age = 19;
let bee = "蜜 蜂"
function print(){
    return "函数调用";
}
</script>

<template>
    <div>
        <h1 v-text="msg"></h1>
        <h1 v-text="msg2"></h1>
        <h1 v-text="`你好 ${haha}`"></h1>
        <h1 v-text="age>=18?'是':'否'"></h1>
        <h1 v-text="bee.split(' ').reverse().join('')"></h1>
        <h1 v-text="print()"></h1>
    </div>
</template>


<style scoped>

</style>