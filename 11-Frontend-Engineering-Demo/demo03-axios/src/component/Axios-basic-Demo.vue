<script setup lang="ts">

import axios from "axios";
import {reactive} from "vue";

type Historyitem = {
    date: string;
    title: string;
}
let message = reactive({
    list: [] as Historyitem[]
})

function getMessage() {
    // 使用axios发送请求获取
    //    axios({设置请求的参数})  请求三要素：1. 请求的URL 2. 请求的方式 3.请求的参数 keyvalue json

    let promise = axios({
        method: "get",
        url: "https://api.oick.cn/api/lishi",
        // data:{
        //      这里的数据都会放入请求体，前提是请求方式是post
        //     // 如果请求方式是get,则需要通过params进行发送
        //     // 如果请求方式是post,则data中的数据会以JSON形式放入请求体
        // },
        params: {
            // 都是以键值对方式将数据放在URL后
            apikey: '5a03e0d32aa097919419a560842c0ce4'
        }
    })
    promise.then((response) => {
        console.log(response)
        // 将第二个参数的同名属性赋值给第一个参数
        Object.assign(message, {
            list: response.data.result
        })
    }).catch((error) => {
        console.log("catch" + error)
    })
}
</script>

<template>
    <div class="page">
        <h1>历史上的今天</h1>
        <div class="table">
            <div>日期</div>
            <div>事件</div>
            <template class="field" v-for="item in message.list">
                <div>{{ item.date }}</div>
                <div>{{ item.title }}</div>
            </template>
        </div>
        <button @click="getMessage()">change</button>
    </div>
</template>
<style scoped>
.page {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.table {
    display: grid;
    grid-template-columns: 200px 300px;
    gap: 10px 15px;
    justify-content: center;
    align-items: center;
}

.table template {
    border-bottom: 1px solid #9ca3af;
}

button {
    margin-top: 20px;
}
</style>
