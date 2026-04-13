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
            <div class="table-head-row">
                <div class="table-head">编号</div>
                <div class="table-head">内容</div>
                <div class="table-head">进度</div>
                <div class="table-head">操作</div>
            </div>

            <div
                    class="table-row"
                    v-for="(item,index) in schedule.itemList"
                    :key="index"
                    :class="{striped:index%2 ===1}"
            >
                <div class="table-cell" v-text="index+1"></div>
                <div class="table-cell">
                    <input type="text" v-model="item.title">
                </div>
                <div class="table-cell-radio">
                    <label>
                        <input type="radio" value="1" v-model="item.completed">已完成
                    </label>
                    <label>
                        <input type="radio" value="0" v-model="item.completed">未完成
                    </label>
                </div>
                <div class="field-btn-list">
                    <button @click="deleteSchedule(index)">删除</button>
                    <button @click="keepUpdate(index)">保存修改</button>
                </div>
            </div>

        </div>
        <button @click="addSchedule()" class="addSchedule">新增日程</button>

    </div>
</template>

<style scoped>
.page {
    width: 100%;
    min-height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
    padding: 20px 0 32px;
    box-sizing: border-box;
    background-color: #f7f9fc;
}

.welcome {
    font-size: 18px;
    color: #606266;
}

.content {
    width: 960px;
    border: 1px solid #e4e7ed;
    border-radius: 12px;
    overflow: hidden;
    background-color: #ffffff;
    box-shadow: 0 4px 16px rgba(31, 45, 61, 0.08);
}

.table-head-row {
    display: grid;
    grid-template-columns: 80px 1.8fr 1.2fr 180px;
    background-color: #f5f7fa;
    border-bottom: 1px solid #ebeef5;
}

.table-head {
    min-height: 54px;
    padding: 0 16px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 16px;
    font-weight: 700;
    color: #606266;
    box-sizing: border-box;
}

.table-row {
    display: grid;
    grid-template-columns: 80px 1.8fr 1.2fr 180px;
    border-bottom: 1px solid #ebeef5;
    transition: background-color 0.2s;
}

.table-row:last-child {
    border-bottom: none;
}

.table-row.striped {
    background-color: #fafafa;
}

.table-row:hover {
    background-color: #f5f7fa;
}

.table-cell,
.table-cell-radio,
.field-btn-list {
    min-height: 58px;
    padding: 10px 14px;
    display: flex;
    align-items: center;
    justify-content: center;
    box-sizing: border-box;
    color: #606266;
    font-size: 14px;
}

.table-cell input[type="text"] {
    width: 100%;
    height: 36px;
    padding: 0 12px;
    border: 1px solid #dcdfe6;
    border-radius: 6px;
    outline: none;
    font-size: 14px;
    color: #606266;
    background-color: #ffffff;
    box-sizing: border-box;
    transition: border-color 0.2s, box-shadow 0.2s;
}

.table-cell input[type="text"]:focus {
    border-color: #409eff;
    box-shadow: 0 0 0 2px rgba(64, 158, 255, 0.15);
}

.table-cell-radio {
    gap: 18px;
    flex-wrap: nowrap;
}

.table-cell-radio label {
    display: flex;
    align-items: center;
    gap: 6px;
    white-space: nowrap;
    cursor: pointer;
    color: #606266;
}

.table-cell-radio input[type="radio"] {
    margin: 0;
}

.field-btn-list {
    gap: 10px;
}

.field-btn-list button {
    min-width: 76px;
    height: 34px;
    padding: 0 12px;
    border: 1px solid #dcdfe6;
    border-radius: 6px;
    background-color: #ffffff;
    color: #606266;
    font-size: 14px;
    cursor: pointer;
    transition: all 0.2s;
}

.field-btn-list button:hover {
    border-color: #409eff;
    color: #409eff;
    background-color: #ecf5ff;
}

.addSchedule {
    width: 180px;
    height: 40px;
    border: 1px solid #409eff;
    border-radius: 8px;
    background-color: #409eff;
    color: #ffffff;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.2s;
}

.addSchedule:hover {
    background-color: #66b1ff;
    border-color: #66b1ff;
}

</style>