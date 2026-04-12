<script setup lang="ts">
import {definedSchedule} from '../store/scheduleStore.ts'
import {definedUser} from '../store/userStore.ts'
import {useRouter} from "vue-router";

let sysUser = definedUser();
let schedule = definedSchedule();

const router = useRouter();

function logout(){
    sysUser.$reset();
    schedule.$reset();
    // 跳转到登录页
    router.push("/login");
}

</script>

<template>
    <div class="page">
        <div class="welcome">
            欢迎使用长空日程管理系统
        </div>

        <div class="optionDiv" v-if="sysUser.username===''">
            <div class="btnList">
                <router-link to="login">
                    <button>登录</button>
                </router-link>
                <router-link to="register">
                    <button>注册</button>
                </router-link>
            </div>
            <hr>
        </div>

        <div class="optionDiv" v-else>
            <div class="btnList">
                欢迎 {{sysUser.username}}
                <button @click="logout()">退出登录</button>
                <router-link to="showSchedule">
                    <button>查看我的日程</button>
                </router-link>
            </div>
            <hr>
        </div>
    </div>
</template>

<style scoped>
.page {
    //height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 10px;
}
hr {
    width: 960px;
}

.welcome {
    font-size: 40px;
}

.optionDiv {
    display: flex;
    gap: 10px;
    flex-direction: column;
    justify-content: center;
}

.btnList {
    display: flex;
    justify-content: center;
    gap: 20px;
}
.btnList button {
    width: 100px;
}
</style>