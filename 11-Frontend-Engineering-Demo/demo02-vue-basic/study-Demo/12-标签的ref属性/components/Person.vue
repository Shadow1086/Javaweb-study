<template>
    <div class="person">
        <h1>中国</h1>
        <h2 ref="title2">北京</h2>
        <h3>尚硅谷</h3>
        <button @click="showLog">点击输出h2元素</button>
    </div>
</template>


<script lang="ts" setup>

//创建容器,title2,用于存储ref标记的内容
import {ref} from "vue";
//相当于局部变量，其他文件的相同名称不影响
let title2 = ref();
let a = ref(0)
let b = ref(1)
let c = ref(2)
function showLog(){
    console.log(title2.value)
}
//向父组件暴露,这样如果app中的person中加了ref属性，才能看到person中的a,b,c的三个值
defineExpose({a:a.value,b:b.value,c:c.value});
</script>

<!-- scoped : 局部样式-->
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