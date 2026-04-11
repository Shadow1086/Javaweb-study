<template>
    <div class="person">
        <h1>情况三：监视reactive定义的对象类型数据</h1>
        <h2>姓名：{{person.name}}</h2>
        <h2>年龄：{{person.age}}</h2>
        <button @click="changeName">修改名字</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="change">修改整个人</button>
        <hr>
        <h2>测试数据：{{a.b.c}}</h2>
        <button @click="changeTest">修改测试数据</button>
    </div>
</template>


<script lang="ts" name="Person" setup>
    import {reactive,watch} from "vue";
    let person = reactive({
        name:'张三',
        age:18
    })
    let a=reactive({
        b:{
            c:666
        }
    })
    function changeTest(){
        a.b.c = 888;
    }
    watch(a,(newValue,oldValue)=>{
        console.log('a变化了',oldValue,newValue)
    })
    function changeName(){
        person.name+='~';
    }
    function changeAge(){
        person.age+=1;
    }
    function change(){
        Object.assign(person,{name:'李四',age:34})
    }

    // 监视:默认开启深度监视
    watch(person,(newValue,oldValue)=>{
        console.log('person变化了',oldValue,newValue);
    })
</script>

<style scoped>
.person {
    background-color: skyblue;
    box-shadow: 0 0 10px;
    border-radius: 10px;
    padding: 20px;
}

li {
    font-size: 20px;
}

</style>