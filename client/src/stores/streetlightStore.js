import { defineStore } from 'pinia'

export const useStreetlightStore = defineStore('streetlight', {
    state: () => ({
        streetlights: [],
        streetlight: {},
    }),
    getters: {
        getStreetlights: (state) => state.streetlights,
        getStreetlight: (state) => state.streetlight
    },
    actions: {
        async fetchStreetlights(){
            try {
                const response = await fetch('http://localhost:3000/streetlights')
                const streetlights = await response.json()
                this.streetlights = streetlights
            } catch (error) {
                console.error(error)
            }
        },
        addStreetlight(streetlight){
            this.streetlights.push(streetlight)
        }
    }
})