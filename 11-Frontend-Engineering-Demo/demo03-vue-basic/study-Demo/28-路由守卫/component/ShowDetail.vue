<script setup lang="ts">

const props = defineProps<{
    id:string,
    language:string
}>();

</script>

<template>
    <div>
        <h1>ShowDetail接收路径参数</h1>
        <h3>{{ props.id }}{{ props.language }}是世界上最好的编程语言</h3><br>
    </div>
</template>

<style scoped>

</style>