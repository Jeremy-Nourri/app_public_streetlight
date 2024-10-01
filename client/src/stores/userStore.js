import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    username: '',
    isAuthenticated: false,
  }),
    getters: {
        getUsername: (state) => state.username,
        isAuthenticated: (state) => state.isAuthenticated
    },
    actions: {
        login(username){
          this.username = username,
          this.isAuthenticated = true;
        },
        logout(){
          this.username = ""
          this.isAuthenticated = false
        },
    }
})