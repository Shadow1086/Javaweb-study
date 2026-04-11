<script setup lang="ts">
import {ref} from "vue";
import {useRouter} from "vue-router";

let username = ref();
let password = ref();
const router = useRouter();

function login() {
    // 获取用户名和密码，如果用户名是root,密码是123456 则登录成功
    if (username.value=== "root" && password.value === "123456") {
        // 进行路由的跳转
        // 使用session进行会话的存储，sessionStorage,localStorage
        window.sessionStorage.setItem("username",username.value);
        router.push({name:"home"});
    }else {
        alert("用户名密码错误")
    }
}
</script>

<template>
<div>
    <h1>Login</h1>
    <label for="username">用户名：</label><input type="text" id="username" v-model="username"><br>
    <label for="password">密码：</label><input type="text" id = "password" v-model="password"><br>
    <button @click="login">登录</button>
</div>
</template>

<style scoped>

</style>