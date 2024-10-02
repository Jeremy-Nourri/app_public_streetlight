<script setup>

import { ref } from 'vue';

import { useStreetlightStore } from '../stores/streetlightStore';

function toggleLamp() {
    isActive.value = !isActive.value;
}

const isActive = ref(false);


</script>

<template>
    <div class="w-full flex items-center justify-center h-screen">
        <div>

            <div class="relative flex flex-col items-center">

                <div class="h-16 w-16 rounded-full transition-all duration-300"
                    :class="isActive ? 'bg-yellow-400 shadow-lg' : 'bg-gray-300'">
                </div>

                <div class="bg-gray-800 h-40 w-4 mt-2">
                </div>
            </div>

            <button @click="toggleLamp"
                class="mt-6 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 transition">
                {{ isActive ? 'Éteindre' : 'Allumer' }} la lumière
            </button>
        </div>
    </div>
</template>

<style>
.shadow-lg {
  box-shadow: 0 0 30px 10px rgba(255, 223, 0, 0.6);
}
</style>