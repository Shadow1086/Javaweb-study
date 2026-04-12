<script setup lang="ts">
// import {reactive} from "vue";

// let items = reactive()

import {definedSchedule} from "../store/scheduleStore.ts";
import {definedUser} from "../store/userStore.ts";
import {onMounted} from "vue";
import request from "../util/request.ts";

let sysUser = definedUser();
let schedule = definedSchedule();


// 挂载完毕后，立刻查询当前用户的所有日程信息，赋值给pinia
onMounted(async () => {
    // 发送异步请求
    let {data} = await request.post("/schedule/findAllSchedule", null, {
        params: {uid: sysUser.uid}
    })
    // console.log(data);
    schedule.itemList = data.data.itemList;
    console.log(schedule.itemList)
})

function addSchedule() {
    alert("此功能正在更新中");
}
function deleteSchedule(){
    alert("此功能正在更新中");
}
function keepUpdate(){
    alert("此功能正在更新中");
}
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

            <template v-for="(item,index) in schedule.itemList" :key="index">
                <div class="field" v-text="index+1"></div>
                <div class="field">
                    <input type="text" v-model="item.title">
                </div>
                <div class="field-radio">
                    <label>
                        <input type="radio" value="1" v-model="item.completed" id="completed">已完成
                    </label>
                    <label>
                        <input type="radio" value="0" v-model="item.completed" id="completed">未完成
                    </label>
                </div>
                <div class="field-btn-list">
                    <button @click="deleteSchedule()">删除</button>
                    <button @click="keepUpdate()">保存修改</button>
                </div>
            </template>
        </div>
        <button @click="addSchedule()" class="addSchedule">新增日程</button>

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
    width: 900px;
    border: 1px solid deepskyblue;
    display: grid;
    grid-template-columns: 50px 250px 280px 200px;
    justify-content: center;
    gap: 10px;
    padding-bottom: 10px;
}

.field {
    //border-left: 1px solid #888888;
    display: flex;
    justify-content: center;
}

.content div {
    height: 25px;
}
.field-radio {
    font-size: 14px;
    display: flex;
    justify-content: center;
    align-items: center;
}
.field-btn-list {
    display: flex;
    gap: 5px;
    justify-content: center;
}
.addSchedule {
    width: 200px;
}
</style>