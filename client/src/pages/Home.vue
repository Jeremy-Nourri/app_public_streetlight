<script setup>
import { onMounted, computed } from 'vue';
import { useStreetlightStore } from '../stores/streetlightStore';
import jourImage from '../assets/img/jour.jpg';
import nuitImage from '../assets/img/nuit.jpg';

const streetlightStore = useStreetlightStore();

const streetlightId = 1;

onMounted(() => {
    console.log('Démarrage de la récupération du statut du lampadaire');
    streetlightStore.startFetchingStatusAndTime(streetlightId);
});

const isActive = computed(() => streetlightStore.getIsActive);

const backgroundImage = computed(() => streetlightStore.getIsActive ? nuitImage : jourImage);

const time = computed(() => streetlightStore.getTime);

</script>

<template>
    <div class="w-full flex flex-col items-center justify-center h-screen">
        <div class="flex flex-col items-center mb-8">
            <p class="text-xl">Les lampadaires sont actuellement {{ isActive ? 'allumés' : 'éteints' }}</p>
            <p class="text-xl">Il est {{ time }} H</p>
        </div>
        <div class="flex justify-between items-end w-8/12 h-96 bg-center py-4 px-14" :style="{ backgroundImage: `url(${backgroundImage})` }">
            <div class="relative flex flex-col items-center">
                <div class="h-12 w-12 rounded-full transition-all duration-300"
                    :class="isActive ? 'bg-yellow-400 shadow-lg' : 'bg-gray-300'">
                </div>
                <div class="bg-gray-800 h-28 w-4 mt-2"></div>
            </div>
            <div class="relative flex flex-col items-center">
                <div class="h-12 w-12 rounded-full transition-all duration-300"
                    :class="isActive ? 'bg-yellow-400 shadow-lg' : 'bg-gray-300'">
                </div>
                <div class="bg-gray-800 h-28 w-4 mt-2"></div>
            </div>
        </div>
    </div>
</template>

<style>
.shadow-lg {
  box-shadow: 0 0 30px 10px rgba(255, 223, 0, 0.6);
}
</style>