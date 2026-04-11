<template>
    <div class="person">
        <h2>当前求和为{{sum}}</h2>
        <button @click="sumAdd">点击求和+1</button>
    </div>
</template>


<script lang="ts" setup>
import {onBeforeMount, onBeforeUnmount, onBeforeUpdate, onMounted, onUnmounted, onUpdated, ref} from "vue";

let sum = ref(1);

function sumAdd(){
    sum.value++;
}
// 创建   setup替代了beforeCreate/created
console.log('创建');

//挂载,在挂载前调用onBeforeMount中传入的回掉函数
onBeforeMount(()=>{
    console.log('挂载前')
})
onMounted(()=>{
    console.log('挂载完毕')
})
// 更新
onBeforeUpdate(()=>{
    console.log('更新前')
})
onUpdated(()=>{
    console.log('更新完毕')
})
//卸载
onBeforeUnmount(()=>{
    console.log('卸载前')
})
onUnmounted(()=>{
    console.log('卸载完毕')
})

</script>

<style scoped>
    .person{
        background-color: skyblue;
        padding: 10px;
        border-radius: 10px;
        box-shadow: 0 0 10px;
    }
</style>