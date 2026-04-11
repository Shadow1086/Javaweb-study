<script setup lang="ts">

import axios from "axios";

function getMessage(){
    // 使用axios发送请求获取
    //    axios({设置请求的参数})  请求三要素：1. 请求的URL 2. 请求的方式 3.请求的参数 keyvalue json

    let promise = axios({
        method:"get",
        url:"https://api.oick.cn/api/dog",
        data:{
            // 如果请求方式是get,则data中的数据回忆键值对形式放在url后面
            // 如果请求方式是post,则data中的数据回忆JSON形式放入请求体
            apikey:'2f35110e13021186394787624629e837'
        }
    })
    promise.then((response)=>{
        console.log(response)
    }).catch(()=>{

    })
}
</script>

<template>
    <div>
        <h1></h1>
        <button @click="getMessage()">change</button>
    </div>
</template>
