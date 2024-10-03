import { defineStore } from 'pinia';

export const useStreetlightStore = defineStore('streetlight', {
    state: () => ({
        isActive: false,
        time: null
    }),
    getters: {
        getIsActive: (state) => state.isActive,
        getTime: (state) => state.time
    },
    actions: {
        async fetchStreetlightStatusById(id) {
            try {
                const response = await fetch(`http://localhost:8080/api/streetlights/${id}/status`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json', 
                    }
                });
        
                if (response.ok) {
                    const data = await response.json();

                    if (typeof data === 'boolean') {
                        this.$patch({ isActive: data });
                    } else {
                        console.error('Données inattendues reçues:', data);
                    }
                } else {
                    console.error('Erreur lors de la récupération de l\'état du lampadaire.');
                }
            } catch (error) {
                console.error('Erreur de réseau:', error);
            }
        },

        async fetchTime() {
            try {
                const response = await fetch('http://localhost:8080/api/streetlights/time', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json', 
                    }
                });
        
                if (response.ok) {
                    const data = await response.json();

                    if (typeof data === 'number') {
                        this.$patch({ time: data });
                    } else {
                        console.error('Données inattendues reçues:', data);
                    }

                } else {
                    console.error('Erreur lors de la récupération de l\'heure actuelle.');
                }
            } catch (error) {
                console.error('Erreur de réseau:', error);
            }
        },

        startFetchingStatusAndTime(id) {
            this.fetchStreetlightStatusById(id);
            this.fetchTime();
            setInterval(() => {
                this.fetchStreetlightStatusById(id);
                this.fetchTime();
            }, 5000);
        }
    }
});