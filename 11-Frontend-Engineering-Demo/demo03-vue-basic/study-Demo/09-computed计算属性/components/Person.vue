<template>
    <div class="person">
        姓：<input v-model="firstName" type="text"><br>
        名：<input v-model="lastName" type="text"><br>
        全名：<span>{{ fullName }}</span>
        <button @click="changeFullName">将全名改为li-si</button>
    </div>
</template>


<script lang="ts" name="Person" setup>
import {computed, ref} from "vue";

let firstName = ref('张');
let lastName = ref('三');

// 以下方式定义的fullName,是一个计算属性，且是只读的，不可修改
// let fullName = computed(()=>{
//     return firstName.value.slice(0,1).toUpperCase() + firstName.value.slice(1)+'-'+lastName.value
// })
// function changeFullName(){
//     // fullName.value = "li-si";
// }

let fullName = computed({
    get() {
        return firstName.value.slice(0, 1).toUpperCase() + firstName.value.slice(1) + '-' + lastName.value
    },
    set(val) {
        const [str1, str2] = val.split('-')
        firstName.value = str1;
        lastName.value = str2;
        console.log('set', val)
    }
})

function changeFullName() {
    fullName.value = 'li-si'
}
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