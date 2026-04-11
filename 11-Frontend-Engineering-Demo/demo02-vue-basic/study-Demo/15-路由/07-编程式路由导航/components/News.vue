<template>
    <div class="news">
        <!--        导航区-->
        <ul>
            <li v-for="news in newsList" :key="news.id">
                <button @click="showDetail(news)">查看新闻</button>
                <RouterLink
                        :to="{
                    name:'newsDetail',
                    query:{
                        id:news.id,
                        title:news.title,
                        content:news.content
                    }
                }"
                >
                    {{ news.title }}
                </RouterLink>
            </li>
        </ul>
        <!--        内容区-->
        <div class="content">
            <RouterView></RouterView>
        </div>
    </div>
</template>


<script lang="ts" setup>

import {reactive} from "vue";
import {useRouter} from "vue-router";

const newsList = reactive([
    {id: 'asdjflk01', title: '一种抗癌食物', content: '西兰花'},
    {id: 'asdjflk02', title: '如何一夜暴富', content: '学IT'},
    {id: 'asdjflk03', title: '震惊', content: '明天是周一'},
    {id: 'asdjflk04', title: '好消息', content: '快过年了'}
])
const router = useRouter()

interface NewsInter {
    id:string,
    title:string,
    content:string
}
function showDetail(news:NewsInter) {
    router.push({
        name: 'newsDetail',
        query: {
            id: news.id,
            title: news.title,
            content: news.content
        }
    })
}
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

ul {
    margin-top: 10px;
    /*list-style: none;*/
}

ul li {
    margin-top: 20px;
    font-size: 18px;
}

li a {
    text-decoration: none;
    color: cadetblue;
}
</style>