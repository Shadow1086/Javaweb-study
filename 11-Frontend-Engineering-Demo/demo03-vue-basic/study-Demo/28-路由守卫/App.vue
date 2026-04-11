<script lang="ts" name="App" setup>
import {useRouter} from "vue-router";
import {ref} from "vue";

const router = useRouter();
let mypath=ref()

function goMyPage() {
    // 编程式路由实现页面跳转
    // router.push("/list");
    router.push({
        path: `${mypath.value}`
    })
}

</script>

<template>
    <div>
        <router-link to="/list">list</router-link>
        <br>
        <router-link to="/add">add</router-link>
        <br>
        <router-link to="/update">update</router-link>
        <br>
        <router-link to="/showDetail/1/java">声明式路由路径传参</router-link>
        <hr>

        <button @click="goMyPage()">go</button>
        <input type="text" v-model="mypath">
        <hr>
        <router-view></router-view>
    </div>
</template>

<style>
</style>