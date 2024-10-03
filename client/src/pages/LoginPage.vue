<script setup>
import { ref } from 'vue'
import { useAuthStore } from '../stores/auth'

    const email = ref('')
    const password = ref('')
    const errorMessage = ref(null)
    const authStore = useAuthStore()

    const handleLogin = async () => {
      try {
        authStore.login(email.value, password.value)
        errorMessage.value = null
      } catch (error) {
        errorMessage.value = error.message
      }
    }

</script>

<template>
    <div>
      <h2>Login</h2>
      <form @submit.prevent="handleLogin">
        <div>
          <label>Nom :</label>
          <input type="text" v-model="lastname" required />
        </div>
        <div>
          <label>Prénom :</label>
          <input type="text" v-model="firstname" required />
        </div>
        <div>
          <label>Email:</label>
          <input type="email" v-model="email" required />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" v-model="password" required />
        </div>
        <button type="submit">Login</button>
      </form>
      <p v-if="errorMessage" style="color: red">{{ errorMessage }}</p>
    </div>
  </template>
  
  