<template>
    <div class="person">
        <h1>情况二：监视ref定义的对象类型数据</h1>
        <h2>姓名：{{person.name}}</h2>
        <h2>年龄：{{person.age}}</h2>
        <button @click="changeName">修改名字</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="change">修改整个人</button>
    </div>
</template>


<script lang="ts" name="Person" setup>
    import {ref,watch} from "vue";
    let person = ref({
        name:'张三',
        age:18
    })

    function changeName(){
        person.value.name+='~';
    }
    function changeAge(){
        person.value.age+=1;
    }
    function change(){
        person.value={name:'李四',age:30}
    }
    //监视,情况二：监视ref定义的对象类型数据,监视的是对象的地址值，若想监视对象内部属性的变化，需要手动开启深度监视
    watch(person,(newValue,oldValue)=>{
        console.log('person变化了',oldValue,newValue)
        // deep:深度监视：监视对象内部属性值的变化
        // immediate:立即执行，为false时，只有对象改变了才会调用watch，而改为true后，最开始就会先执行一次监视
    },{deep:true,immediate:true})
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