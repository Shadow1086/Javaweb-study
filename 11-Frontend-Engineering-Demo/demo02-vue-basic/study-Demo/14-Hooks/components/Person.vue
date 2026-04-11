<template>
    <div class="person">
        <h2>当前求和为：{{ sum }},放大十倍后为：{{bigSum}}</h2>
        <button @click="add">点击sum+1</button>
        <hr>
        <img v-for="(dog,index) in dogList" :key="index" :src="dog" alt="狗狗图片"><br>
        <button @click="addDog">再获得一只狗</button>
    </div>
</template>


<script lang="ts" setup>
import useDog from "@/hooks/useDog.ts";
import useSum from "@/hooks/useSum.ts";

const {sum,add,bigSum} = useSum();
const {dogList,addDog} = useDog();

</script>

<style scoped>
.person {
    background-color: skyblue;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 0 10px;
}

img {
    width: 20%;
    height: 50%;
    margin-right: 10px;
}
</style>