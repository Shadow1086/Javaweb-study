<script setup lang="ts">
import {reactive, ref} from "vue";
import request from '../util/request.ts';
import {useRouter} from "vue-router";

const router = useRouter();

let passwordCon = ref()

let statusUsername = ref();
let statusPwd = ref();
let statusPwdCon = ref();

const registerUser = reactive({
    username: "",
    userPwd: ""
})

async function verifyUsername() {
    const ptnUsername = /^[A-Za-z0-9]{5,10}$/;
    // 校验用户名是否被占用
    let response = await request.post(`/user/checkUsernameUsed?username=${registerUser.username}`);
    console.log(response)
    let message = response.data.message;
    if (message === 'usernameUsed') {
        statusUsername.value = "用户名已被占用"
        return false;
    } else {
        if (ptnUsername.test(registerUser.username)) {
            statusUsername.value = "用户名合法";
            return true;
        } else {
            statusUsername.value = "用户名不合法"
            return false;
        }
    }
}

function verifyPwd() {
    const ptnPwd = /^(?=.*_)[A-Za-z0-9_]{5,10}$/;
    if (ptnPwd.test(registerUser.userPwd)) {
        statusPwd.value = "密码合法";
        return true;
    } else {
        statusPwd.value = "密码不合法";
        return false;
    }
}

function verifyPwdCon() {
    if (registerUser.userPwd === undefined || registerUser.userPwd === "") {
        statusPwdCon.value = "密码不能为空";
    } else if (registerUser.userPwd === passwordCon.value) {
        statusPwdCon.value = "密码正确";
        return true;
    } else {
        statusPwdCon.value = "密码不一致";
        return false;
    }
}

async function register() {
    let flag1 = await verifyUsername();
    let flag2 = await verifyPwd();
    let flag3 = await verifyPwdCon();

    if (flag1 && flag2 && flag3) {
        console.log("用户名密码校验通过，提交表单");
        let {data} = await request.post(`/user/regist`, registerUser);
        alert("注册成功")
        router.push("login");
        console.log(data);
    } else {
        alert("注册失败")
        console.log("校验不通过")
    }
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
                <input v-model="registerUser.username" id="username" type="text"
                       placeholder="请输入用户名" @blur="verifyUsername()">
                <span class="status"
                      :class="{success:statusUsername ==='用户名合法',error:statusUsername==='用户名不合法'}">{{
                        statusUsername
                    }}</span>
            </div>

            <label for="password">密码：</label>
            <div class="form-item">
                <input type="password" v-model="registerUser.userPwd" id="password"
                       placeholder="请输入密码" @blur="verifyPwd()">
                <span class="status"
                      :class="{success:statusPwd==='密码合法' , error : statusPwd==='密码不合法'}">{{
                        statusPwd
                    }}</span>
            </div>

            <label for="password-con">确认密码：</label>
            <div class="form-item">
                <input v-model="passwordCon" id="password-con" type="password"
                       placeholder="请确认密码" @blur="verifyPwdCon()">
                <span class="status"
                      :class="{success:statusPwdCon==='密码正确' , error:statusPwdCon==='密码不一致'}">{{
                        statusPwdCon
                    }}</span>
            </div>

        </form>

        <button @click="register">确认</button>

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
    //height: 100vh;
    //transform: translateY(-180px);
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

form .success {
    color: lightgreen;
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