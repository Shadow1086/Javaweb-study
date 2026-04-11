<template>
    <div class="app">
<!--        标题-->
        <h2 id="title">vue路由测试</h2>
<!--        导航区-->
        <div class="navigate">
            <RouterLink to="/Home" active-class="active">首页</RouterLink>
            <RouterLink to="/News" active-class="active">新闻</RouterLink>
            <RouterLink to="/About" active-class="active">关于</RouterLink>
        </div>
<!--        内容区-->
        <div class="main-content">
            <RouterView></RouterView>
        </div>
    </div>
</template>

<script lang="ts" name="App" setup>

</script>

<style scoped>
    .app {
        width: 960px;
        margin: 0 auto;
    }
    #title {
        background-color: #dddddd;
        height: 70px;
        border-radius: 10px;
        text-align: center;
        line-height: 70px;
    }
    .navigate {
        display: flex;
    }
    .navigate a {
        display: block;
        font-size: 18px;
        color: white;
        background-color: darkgray;
        border-radius: 7px;
        width: 70px;
        margin-left: 200px;
        text-decoration: none;
        text-align: center;
        height: 30px;
        line-height: 30px;
        margin-bottom: 20px;
    }
    .navigate a:hover{
        box-shadow: 0 0 17px darkgray;
    }
    .main-content {
        border: 1px solid black;
        border-radius: 10px;
        width: 900px;
        height: 900px;
        margin: 0 auto;
    }
    .navigate .active{
        background-color: cadetblue;
    }
</style>