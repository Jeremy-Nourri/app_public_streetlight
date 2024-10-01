<script setup>

import { ref } from 'vue';

import { useStreetlightStore } from '../stores/streetlightStore';

const { addStreetlight } = useStreetlightStore();

const streetlight = ref({
    location: '',
    brightness: 0,
    power: 0
})

function handleSubmit() {
    addStreetlight(streetlight.value);
    streetlight.value = {
        location: '',
        brightness: 0,
        power: 0
    }
}

</script>

<template>

    <div class="w-full">
        <h1 class="m-auto">Lampadaire</h1>
        <form @submit.prevent="handleSubmit" class="flex flex-col justify-evenly items-center h-[500px] p-4">
            <div class="flex flex-col">
                <label for="location">Emplacement</label>
                <input type="text" id="location" v-model.trim="streetlight.location">
            </div>
            <div class="flex flex-col">
                <label for="brightness">Luminosité</label>
                <input type="text" id="brightness" v-model.number="streetlight.brightness">
            </div>
            <div class="flex flex-col">
                <label for="power">Puissance</label>
                <input type="text" id="power" v-model.number="streetlight.power">
            </div>
            <button>Enregistrer</button>
        </form>
    </div>
</template>
