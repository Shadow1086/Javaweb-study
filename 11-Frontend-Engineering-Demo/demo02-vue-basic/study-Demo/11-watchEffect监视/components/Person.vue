<template>
    <div class="person">
        <h2>需求：当水温达到60，水位达到80时停止</h2>
        <h2>当前水温：{{ temp }}</h2>
        <h2>当前水位：{{ height }}</h2>
        <button @click="changeTemp">点击增加水温</button>
        <button @click="changeHeight">点击增加水位</button>
    </div>
</template>


<script lang="ts" setup>
import {ref, watchEffect} from "vue";

let temp = ref(10);
let height = ref(0);

function changeTemp() {
    temp.value += 10;
}

function changeHeight() {
    height.value += 10;
}

//监视
// watch([temp, height], (value) => {
//     let tempNew = value[0];
//     let heightNew = value[1];
//     console.log(tempNew,heightNew)
//     if (tempNew >= 60 || heightNew >= 80) {
//         console.log('给服务器发请求')
//     }
// })

// watchEffect

watchEffect(() => {
    if (temp.value >= 60 || height.value >= 80) {
        console.log('给服务器发请求')
    }
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