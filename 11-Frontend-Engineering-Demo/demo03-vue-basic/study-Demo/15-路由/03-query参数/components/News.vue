<template>
    <div class="news">
<!--        导航区-->
        <ul>
            <li v-for="news in newsList" :key="news.id">
<!--                 第一种写法-->
<!--                <RouterLink :to="`/news/detail?id=${news.id}&title=${news.title}&content=${news.content}`">{{ news.title }}</RouterLink>-->
<!--                第二种写法-->
                <RouterLink :to="{
                    // path:'/news/detail',
                    name:'newsDetail',
                    query:{
                        id:news.id,
                        title:news.title,
                        content:news.content
                    }
                }">
                    {{news.title}}
                </RouterLink>
            </li>
        </ul>
<!--        内容区-->
        <div class="content">
            <RouterView></RouterView>
        </div>
    </div>
</template>


<script setup lang="ts">

import {reactive} from "vue";

const newsList = reactive([
    {id:'asdjflk01',title:'一种抗癌食物',content:'西兰花'},
    {id:'asdjflk02',title:'如何一夜暴富',content: '学IT'},
    {id:'asdjflk03',title:'震惊',content: '明天是周一'},
    {id:'asdjflk04',title:'好消息',content: '快过年了'}
])
</script>


<style scoped>
    .news {
        margin: 0 auto;
        display: flex;
        justify-content: space-between;
    }
    .content {
        width: 500px;
        height: 500px;
        background-color: skyblue;
        margin-right: 60px;
        margin-top: 30px;
        border-radius: 15px;
        border: 1px solid black;
    }
    ul{
        margin-top: 10px;
        /*list-style: none;*/
    }
    ul li{
        margin-top: 20px;
        font-size: 18px ;
    }
    li a {
        text-decoration: none;
        color: cadetblue;
    }
</style>