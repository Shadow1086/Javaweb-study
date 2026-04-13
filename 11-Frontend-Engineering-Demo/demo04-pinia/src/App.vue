<script setup lang="ts">

</script>

<template>
    <div>
        <router-link to="/operate">operate</router-link>
        <br>
        <router-link to="/list">list</router-link>
        <hr>
        <router-view/>
        <router-view name="list"/>
    </div>
</template>
