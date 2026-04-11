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

// function getWords() {
//     // 发送get请求的方法,返回promise对象
//     // axios.get(url,{params:{键值对参数},header:{设置一些特殊的请求头}})
//     return axios.get("https://api.oick.cn/api/lishi", {
//         params: {
//             apikey: '5a03e0d32aa097919419a560842c0ce4'
//         }, headers: {
//             Accept: "application/json,text/plain,text/html"
//         }
//     })
// }
function getWords() {
    // axios.post(url,{要放入请求体中的JSON串},{请求的其他信息})
    return axios.post("https://api.oick.cn/api/lishi", {
        username: 'zhangsan',
        password: 'lisi'
    }, {
        params: {
            apikey: '5a03e0d32aa097919419a560842c0ce4'
        }, headers: {
            Accept: "application/json,text/plain,text/html"
        }
    })
}

async function getMessage() {
    let response = await getWords();

    Object.assign(message, {
                list: response.data.result
            }
    )
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
