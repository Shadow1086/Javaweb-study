<script setup lang="ts">

</script>

<template>
    <div class="page">
        <div class="welcome">
            欢迎使用长空日程管理系统
        </div>
        <div class="optionDiv">
            <router-link to="login">
                <button>登录</button>
            </router-link>
            <router-link to="register">
                <button>注册</button>
            </router-link>
        </div>

        <div class="optionDiv">
            欢迎 用户名
            <button>退出登录</button>
            <router-link to="showSchedule">
                <button>查看我的日程</button>
            </router-link>
        </div>
    </div>
</template>

<style scoped>
.page {
    height: 100vh;
    display: flex;
    flex-direction: column;
    //justify-content: center;
    align-items: center;
    gap: 10px;
}
.welcome {
    font-size: 40px;
}
.optionDiv {
    display: flex;
    gap: 10px;
}
</style>