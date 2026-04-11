<script lang="ts" name="App" setup>
const data = {
    logo: "https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/06/16-56-95Nk0B",
    name:"尚硅谷",
    url : "https://www.baidu.com"
}
</script>

<template>
    <div>
        <img v-bind:src="data.logo" v-bind:title="data.name">
        <a v-bind:href="data.url"></a>
    </div>
</template>


<style scoped>

</style>