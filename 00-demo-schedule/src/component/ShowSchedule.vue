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
onMounted(() => {
    showSchedule();
})

async function showSchedule() {
    // 查询当前用户所有日程信息，并展示到视图上的方法
    // 发送异步请求
    let {data} = await request.post("/schedule/findAllSchedule", null, {
        params: {uid: sysUser.uid}
    })
    // console.log(data);
    schedule.itemList = data.data.itemList;
}

async function addSchedule() {
    let {data} = await request.post("/schedule/addSchedule", null, {
        params: {
            uid: sysUser.uid
        }
    })
    if (data.code === 200) {
        //增加成功，刷新页面数据
        showSchedule();
    } else {
        alert("增加失败")
    }
}

async function deleteSchedule(index: number) {
    let {data} = await request.post('/schedule/deleteScheduleBySid', null, {
        params: {sid: schedule.itemList[index].sid}
    });
    if (data.code === 200) {
        console.log("删除成功")
    } else {
        console.log("删除失败")
    }
    showSchedule()
}

async function keepUpdate(index: number) {
    // 找到要修改的数据，发送给服务端，更新进入数据库即可
    let {data} = await request.post('/schedule/updateSchedule', schedule.itemList[index])
    if (data.code === 200) {
        console.log("保存修改成功")
        showSchedule();
    } else {
        alert("更新失败");
    }
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

            <div class="table-row">
                <template v-for="(item,index) in schedule.itemList" :key="index">
                    <div class="field" v-text="index+1" :class="{striped:index%2 ===1}"></div>
                    <div class="field" :class="{striped:index%2 ===1}">
                        <input type="text" v-model="item.title">
                    </div>
                    <div class="field-radio" :class="{striped:index%2 ===1}">
                        <label>
                            <input type="radio" value="1" v-model="item.completed">已完成
                        </label>
                        <label>
                            <input type="radio" value="0" v-model="item.completed">未完成
                        </label>
                    </div>
                    <div class="field-btn-list" :class="{striped:index%2 ===1}">
                        <button @click="deleteSchedule(index)">删除</button>
                        <button @click="keepUpdate(index)">保存修改</button>
                    </div>
                </template>
            </div>
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

/*表格的斑马纹样式*/
.field,
.field-radio,
.field-btn-list {
    padding: 12px 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 48px;
    box-sizing: border-box;
    border-bottom: 1px solid #ebeef5;
    background-color: #fff;
}
.striped{
    background-color: #fafafa;
}
</style>