<script setup>
import { RouterView } from 'vue-router'
import NavBar from './components/NavBar.vue'

</script>

<template>
        <div class="flex h-full">
                <NavBar v-if="$route.meta.showNavbar !== false"/>
                <RouterView />
        </div>


</template>
