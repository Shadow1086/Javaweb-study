<template>
    <div class="talk">
        <button @click="getLoveTalk">获得一句舔狗日记</button>
        <ul>
            <li v-for="talk in talkStore.talkList" :key="talk.id">{{ talk.title }}</li>
        </ul>
    </div>
</template>

<script lang="ts" name="LoveTalk" setup>

import {useLoveTalkStore} from "@/store/loveTalk.ts";

const talkStore = useLoveTalkStore();
talkStore.$subscribe((mutate,state)=>{
    console.log('talkStore里面保存的数据发生了变化',mutate,state);
    localStorage.setItem('talkList',JSON.stringify(state.talkList))
})

function getLoveTalk() {
    talkStore.getLoveTalk();
}
</script>

<style scoped>
.talk {
    background-color: orange;
    border-radius: 10px;
    padding: 10px;
    margin-top: 20px;
    box-shadow: 0 0 10px;
}
</style>