<script lang="ts" name="App" setup>
import {ref} from "vue";

let flag = ref(true);
let reverse = (flag: boolean) => {
    flag = !flag;
}

</script>

<template>
    <div>
        <h1 v-if="flag">vue is awesome!</h1>
        <h1 v-else>oh on!</h1>
        <button @click="reverse(flag)">更改</button>
    </div>
</template>


<style scoped>

</style>