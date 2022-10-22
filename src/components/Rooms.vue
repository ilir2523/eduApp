<script setup lang="ts">
import Navbar from "./Navbar.vue";

const rooms = [
  { id: 1, name: "Math", admin: "Ariel", members: 24 },
  { id: 2, name: "Math", admin: "Ariel", members: 24 },
  { id: 3, name: "Math", admin: "Ariel", members: 24 },
];
</script>
<script lang="ts">
export default {
  name: "RoomsComponent",
  methods: {
    goToDetails(roomId: string) {
      this.$router.push({ name: "room-details", params: { id: roomId } });
    },
  },
};
</script>

<template>
  <header>
    <Navbar></Navbar>
  </header>
  <div class="flex row">
    <div
      @click="goToDetails(room.id.toString())"
      v-for="room of rooms"
      :key="room.name"
      class="relative m-6 w-72 h-72 block p-6 max-w-sm bg-white rounded-lg border border-gray-200 shadow-md hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700"
    >
      <h5
        class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white"
      >
        {{ room.name }}
      </h5>
      <p class="font-normal text-gray-700 dark:text-gray-400">
        {{ room.admin }}
      </p>
    </div>
  </div>
</template>
