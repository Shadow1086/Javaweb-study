<script setup lang="ts">
import {definedPerson} from "../store/store.ts";

let person = definedPerson();
</script>

<template>
<div>
    <h1>用于展示pinia数据</h1>
    <hr>
    <label>名字：</label><input type="text" v-model="person.username"><br>
    <label>年龄：</label><input type="text" v-model="person.age"><br>
    <span>{{ person.getAge }}</span><br>
    <label>爱好：</label>
    <input type="checkbox" v-model="person.hobbies" value="吃饭">吃饭
    <input type="checkbox" v-model="person.hobbies" value="睡觉">睡觉
    <input type="checkbox" v-model="person.hobbies" value="打豆豆">打豆豆
    <input type="checkbox" v-model="person.hobbies" value="唱歌">唱歌
    <input type="checkbox" v-model="person.hobbies" value="跳舞">跳舞
</div>
</template>
