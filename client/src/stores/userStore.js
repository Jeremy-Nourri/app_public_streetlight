import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    user: {
      firstname: '',
      lastname: '',
      email: '',
      password: '',
    },
    isAuthenticated: false,
  }),
  getters: {
    getUser: (state) => state.user,
    getIsAuthenticated: (state) => state.isAuthenticated,
  },
  actions: {
    async signupUser(user) {
      try {
        const response = await fetch('http://localhost:8080/api/user/signup', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(user),
        })

        if (response.ok) {
          console.log('Inscription réussie.')

        } else {
          console.error('Erreur lors de l\'inscription.')
        }
      } catch (error) {
        console.error('Erreur de réseau:', error)
      }
    },

    async loginUser(user) {
      try {
        const response = await fetch('http://localhost:8080/api/user/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(user),
        })

        if (response.ok) {
          this.$patch({ isAuthenticated: true })

          const data = await response.json()
          localStorage.setItem('token', data.token)
        }
      } catch (error) {
        console.error('Erreur de réseau:', error)
      }

      return this.isAuthenticated

    }
  }
})