<script setup lang="ts">
import Navbar from "../components/Navbar.vue";
</script>

<template>
  <header>
    <Navbar />
  </header>
  <main class="flex justify-center mt-32">
    <RouterView />
  </main>
</template>
