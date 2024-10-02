import { defineStore } from 'pinia';

export const useStreetlightStore = defineStore('streetlight', {
    state: () => ({
        isActive: false,
    }),
    getters: {
        isActive: (state) => state.isActive
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
                    this.isActive = data;
                    
                } else {
                    console.error('Erreur lors de la récupération de l\'état du lampadaire.');
                }
            } catch (error) {
                console.error('Erreur de réseau:', error);
            }
        },
        

        startFetchingStatus(id) {
            this.fetchStreetlightStatusById(id);
            setInterval(() => {
                this.fetchStreetlightStatusById(id);
            }, 10000);
        }
    }
});
