<script setup lang="ts">
// 导入Pinia数据
import {definedPerson} from '../store/store.ts';

let person = definedPerson();

</script>

<template>
    <div>
        <h1>用于修改pinia数据</h1>
        <label>名字：</label><input type="text" v-model="person.username"><br>
        <label>年龄：</label><input type="text" v-model="person.age"><br>
        <span>{{ person.getAge }}</span><br>
        <label>爱好：</label>
        <input type="checkbox" v-model="person.hobbies" value="吃饭">吃饭
        <input type="checkbox" v-model="person.hobbies" value="睡觉">睡觉
        <input type="checkbox" v-model="person.hobbies" value="打豆豆">打豆豆
        <input type="checkbox" v-model="person.hobbies" value="唱歌">唱歌
        <input type="checkbox" v-model="person.hobbies" value="跳舞">跳舞
        <br>
        <button @click="person.doubelAge()">年龄加倍</button>
        <!--    恢复默认值    -->
        <button @click="person.$reset()">恢复默认值</button>
        <!--    一次性修改多个属性值     -->
        <button @click="person.$patch({username:'奥特曼',age:30,hobbies: ['吃饭']})">变身</button>
        <hr>
        展示一下person中的数据 <br>
        {{ person }}
    </div>
</template>
