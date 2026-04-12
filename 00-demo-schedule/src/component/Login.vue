<script setup lang="ts">
import {reactive, ref} from "vue";
import {useRouter} from "vue-router";
import request from "../util/request.ts";


const loginUser = reactive({
    username: "",
    userPwd: ""
})

let infoUsername = ref()
let infoPwd = ref();

const router = useRouter();

function register() {
    router.push("/register");
}

function verifyUsername() {
    const patternUser = /^[A-Za-z0-9]{5,10}$/;
    if (loginUser.username !== "") {
        if (patternUser.test(loginUser.username)) {
            infoUsername.value = "用户名格式正确";
            return true;
        } else {
            infoUsername.value = "用户名格式不正确"
        }
        return false;
    }
}

function verifyPwd() {
    const patternPwd = /^[?=.*_][A-Za-z0-9_]{5,10}$/;
    if (loginUser.userPwd != "") {
        if (patternPwd.test(loginUser.userPwd)) {
            infoPwd.value = "密码格式正确";
            return true;
        } else {
            infoPwd.value = "密码格式不正确";
        }
        return false;
    }
}

async function login() {
    if (verifyPwd() && verifyUsername()) {
        let {data} = await request.post("/user/login", loginUser);
        if (data.code === 501) {
            alert("用户名有误")
        } else if (data.code === 503) {
            alert("密码有误")
        } else if (data.code === 200) {
            alert("登录成功")
            // 进行跳转
            router.push("showSchedule")
        } else {
            alert("未知错误")
        }
    }
}

</script>

<template>
    <div class="page">
        <div class="welcome">
            <div>欢迎来到长空日志管理</div>
            <div>请登录</div>
        </div>
        <form action="">
            <label for="username">用户名：</label>
            <div class="field">
                <input type="text" id="username" v-model="loginUser.username" @blur="verifyUsername">
                <span class="status">{{ infoUsername }}</span>
            </div>
            <label for="username">密码：</label>
            <div class="field">
                <input type="text" id="password" v-model="loginUser.userPwd" @blur="verifyPwd()">
                <span class="status">{{ infoPwd }}</span>
            </div>
        </form>
        <div class="btnList">
            <button @click="login">登录</button>
            <button @click="register">去注册</button>
            <button @click="">重置</button>
        </div>
    </div>
</template>

<style scoped>
* {
    padding: 0;
    margin: 0;
}

/* #region start 整个网页垂直居中，flex垂直布局 */
.page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 8px;
    height: 100vh;
    transform: translateY(-140px);
}

/* #endregion end */

/* #region start 欢迎标语 */
.welcome {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.welcome > div:first-child {
    font-size: 36px;
}

.welcome > div:last-child {
    font-size: 28px;
}

/* #endregion */

/*  #region 表单收集部分*/
form {
    display: grid;
    grid-template-columns: 120px 280px;
    grid-template-rows: repeat(2, auto);
    gap: 16px;
    align-items: center;
}

form label {
    display: flex;
    align-items: center;
    justify-content: end;
    transform: translateX(-20px);
}

form input {
    height: 24px;
    padding: 0 12px;
    box-sizing: border-box;
    width: 180px;
}

.field {
    display: flex;
    gap: 3px;
    align-items: center;
    justify-items: center;
}

.status {
    font-size: 10px;
    color: #888;
}

/* #endregion  */

/*  #region 按钮区域    */
.btnList {
    display: flex;
    justify-items: center;
    gap: 5px;
}

.btnList button {
    width: 60px;
    height: 29px;
}
</style>