<template>
    <div class="talk">
        <button @click="getLoveTalk">获得一句舔狗日记</button>
        <ul>
            <li v-for="talk in talkList" :key="talk.id">{{ talk.title }}</li>
        </ul>

    </div>
</template>

<script lang="ts" name="LoveTalk" setup>
import {reactive} from "vue";
import axios from "axios";
import {nanoid} from "nanoid";
//数据
let talkList = reactive([
    {id: 'ahsdif01', title: '今天你有点怪，哪里怪？怪好看的！'},
    {id: 'ahsdif02', title: '“你是不是作弊了？”“那为什么你在我心里总是满分？”'},
    {id: 'ahsdif03', title: '“我想买一块地。”“什么地？”“你的死心塌地。”'},
    {id: 'ahsdif04', title: '“我有个秘密，需要嘴对嘴告诉你的。”'},
    {id: 'ahsdif05', title: '“你以后走路能不能看着点啊。”“非要撞在我心上！”'}
])

// 使用 npm i axios 来引入axios,使用网络上的api
async function getLoveTalk() {
    // 发请求
    // let {data:{content:title}} = await  axios.get('https://api.uomg.com/api/rand.qinghua?format=json');
    // 以上这个写法是将下面的result中的data.content重命名为title,即' 连续结构赋值 + 重命名 ',因此下方obj的对象中的title属性触发简写形式，即可简写为：
    // let obj={id:nanoid(),title}
    let result = await axios.get('https://api.oick.cn/api/dog?apikey=2f35110e13021186394787624629e837');
    // // 把请求回来的字符串包装成为一个对象,使用 npm i uuid,生成唯一字符串作为ID，或者使用npm i nanoid，比较短
    // console.log(result)
    let obj = {id: nanoid(), title: result.data};
    talkList.unshift(obj)
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