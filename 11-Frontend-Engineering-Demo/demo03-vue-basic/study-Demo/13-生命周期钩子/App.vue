<template>
    <Person v-if="isShow"/>
</template>

<script lang="ts" name="App" setup>
import Person from './components/Person.vue'
import {ref} from "vue";

let isShow = ref(true);

</script>

<style></style>