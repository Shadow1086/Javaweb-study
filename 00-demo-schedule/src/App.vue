<script setup lang="ts">
import Header from "./component/Header.vue";
</script>

<template>
    <div class="container">
        <Header/>
        <router-view/>
    </div>

</template>

<style>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 30px;
    transform: translateY(80px);
}
</style>