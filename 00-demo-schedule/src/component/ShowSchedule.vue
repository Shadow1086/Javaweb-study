<script setup lang="ts">
// import {reactive} from "vue";

// let items = reactive()
</script>

<template>
    <div class="page">
        <div class="header">
            欢迎使用日程管理系统
        </div>
        <div class="welcome">您的日程如下：</div>
        <div class="content">
            <div class="field">编号</div>
            <div class="field">内容</div>
            <div class="field">进度</div>
            <div class="field">操作</div>

            <template>
                <div class="field"></div>
            </template>
        </div>

    </div>
</template>

<style scoped>
.page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 20px;
}

.content {
    border: 1px solid deepskyblue;
    display: grid;
    grid-template-columns: 50px 250px 80px 100px;
}
</style>