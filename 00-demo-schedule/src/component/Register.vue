<script setup lang="ts">
import {ref} from "vue";

let username = ref();
let password = ref();
let passwordCon = ref()

let statusUsername = ref();
let statusPwd = ref();
let statusPwdCon = ref();

function verifyUsername() {
    const ptnUsername = /^[A-Za-z0-9]{5,10}$/;
    statusUsername.value = ptnUsername.test(username.value) ? "用户名合法" : "用户名不合法"
}

function verifyPwd() {
    const ptnPwd = /^(?=.*_)[A-Za-z0-9_]{5,10}$/;
    statusPwd.value = ptnPwd.test(password.value) ? "密码合法" : "密码不合法"
}
function verifyPwdCon() {
    statusPwdCon.value = (password.value === passwordCon.value)? "密码正确" : "密码不一致"
}


</script>

<template>
    <div class="page">
        <div class="welcome">
            <div>欢迎登录长空日程管理</div>
            <div>请注册</div>
        </div>

        <form action="#">
            <label for="username">用户名：</label>
            <div class="form-item">
                <input v-model="username" id="username" type="text"
                       placeholder="请输入用户名" @blur="verifyUsername()">
                <span class="status" :class="{success:statusUsername ==='用户名合法',error:statusUsername==='用户名不合法'}">{{ statusUsername }}</span>
            </div>

            <label for="password">密码：</label>
            <div class="form-item">
                <input type="password" v-model="password" id="password"
                       placeholder="请输入密码" @blur="verifyPwd()">
                <span class="status" :class="{success:statusPwd==='密码合法' , error : statusPwd==='密码不合法'}">{{statusPwd}}</span>
            </div>

            <label for="password-con">确认密码：</label>
            <div class="form-item">
                <input v-model="passwordCon" id="password-con" type="password"
                       placeholder="请确认密码" @blur="verifyPwdCon()">
                <span class="status" :class="{success:statusPwdCon==='密码正确' , error:statusPwdCon==='密码不一致'}">{{statusPwdCon}}</span>
            </div>

        </form>

        <button @click="">确认</button>

    </div>
</template>

<style scoped>
/*   #region全局   */
.page {
    padding: 0;
    margin: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    transform: translateY(-180px);
}

/*   #endregion   */

/*   #region 欢迎词   */
.welcome {
    display: flex;
    flex-direction: column;
    justify-items: center;
    align-items: center;
    gap: 12px;
}

.welcome > div:first-child {
    font-size: 36px;
}

.welcome > div:last-child {
    font-size: 28px;
}

/*   #endregion   */

/*   #region 表单   */
form {
    display: grid;
    grid-template-columns: 120px 260px;
    gap: 10px;
    align-items: center;
    margin-top: 10px;
}

form label {
    display: flex;
    align-items: end;
    justify-content: end;
}

form input {
    height: 20px;
}

form .form-item {
    display: flex;
    justify-content: start;
    gap: 5px;
}

form .status {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 12px;
    color: #888888;
}

/*  控制提示文字颜色状态*/

form .error {
    color: red;
}
 form .success{
    color:lightgreen;
}
/*   #region 确认按钮  */
button {
    width: 80px;
    margin-top: 10px;
}

/*   #endregion   */

/*   #region   */
/*   #endregion   */

/*   #region   */
/*   #endregion   */


</style>