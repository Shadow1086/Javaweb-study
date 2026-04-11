<script lang="ts" name="App" setup>
//    单项绑定：v-bind  响应式数据发生变化时，更新dom树，用户的操作不会影响响应式数据
//      双向绑定：v-model 页面的数据由于用唬得操作造成了改变，也会同步修改对应的响应式数据
//          双向绑定一般都用于表单标签，也有人称呼为搜集表单信息的命令
// v-model
import {reactive, ref} from "vue";

let user = reactive({
    username: "",
    userPwd: ""
})
let hbs = ref([]);
</script>

<template>
    <div>
        <input type="text" v-model="user.username"><br>
        <input type="password" v-model="user.userPwd"><br>
        爱好：
        唱 <input type="checkbox" v-model="hbs" value="sing">
        跳 <input type="checkbox" v-model="hbs" value="dance">
        rap <input type="checkbox" v-model="hbs" value="rap"><br>
        {{ user }}<br>
        {{ hbs }}

    </div>
</template>


<style scoped>

</style>