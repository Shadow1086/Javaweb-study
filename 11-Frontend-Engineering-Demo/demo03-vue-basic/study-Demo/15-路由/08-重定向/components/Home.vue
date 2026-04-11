<template>
    <div class="home">
        <img src="https://images.dog.ceo/breeds/pembroke/n02113023_5739.jpg" alt="home中的狗狗图片">
    </div>
</template>
<script lang="ts" setup name="Home">
import {onMounted} from "vue";
import {useRouter} from "vue-router";

const router = useRouter();

onMounted(()=>{
    setTimeout(()=>{
        // 在此处编写的代码，让路由实现跳转，即编程式路由导航
        router.push('/news')
    },3000)
})
</script>


<style scoped>
.home {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
}
</style>