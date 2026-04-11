<script lang="ts" name="App" setup>


</script>

<template>
    <router-link to="/add">add</router-link>
    <br>
    <router-link to="/update">update</router-link>
    <br>
    <router-link to="/list">list</router-link>
    <br>
    <hr>

    <router-view name="addView"/>
    <br>
    <hr>
    <router-view name="updateView"/>
    <br>
    <hr>
    <router-view name="listView"/>
    <br>
    <hr>

</template>
<style>
</style>