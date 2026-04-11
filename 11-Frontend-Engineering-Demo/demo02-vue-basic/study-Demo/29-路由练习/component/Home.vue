<script setup lang="ts">

import {useRouter} from "vue-router";

let sessionUsername = window.sessionStorage.getItem("username");

const router = useRouter();
alert(sessionUsername);
function quit(){
    // 1. 清楚sessionStorage中功能用户登录的信息
    window.sessionStorage.removeItem("username");
    //2. 跳转到login视图
    router.push("/login");
}
</script>

<template>
    <div>
        <h1>Home界面</h1>
        <h3>欢迎登录 {{ sessionUsername }} !!</h3>
        <button @click="quit">退出登录</button>
    </div>
</template>

<style scoped>

</style>