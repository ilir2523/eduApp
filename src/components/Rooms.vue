<script setup lang="ts">
import Navbar from "./Navbar.vue";
</script>
<script lang="ts">
import axios from "axios";
export default {
  name: "RoomsComponent",
  data() {
    return {
      rooms: [{ roomId: 0, name: "", creator: { firstName: "" } }],
      user: null
    };
  },
  mounted() {
  if (this.user) {
    this.getRooms();
  }
  },
  methods: {
    goToDetails(roomId: string) {
      this.$router.push({ name: "room-details", params: { id: roomId } });
    },
    getUser() {
        this.user = JSON.parse(localStorage.getItem("user")!);
    },
    getRooms() {
      axios
        .get("http://localhost:8080/api/rooms/user", {
          params: { userId: this.user.userId },
        })
        .then((res) => {
          console.log(res.data.data);
          this.rooms = res.data.data;
        });
    },
  },
};
</script>

<template>
  <div class="">
    <div class="flex flex-col">
      <h1 class="px-6">Your Rooms</h1>
      <div class="relative flex p-6 items-center">
        <div class="flex-grow border-t border-gray-400"></div>
        <div class="flex-grow border-t border-gray-400"></div>
      </div>
      <div class="flex row">
        <div
          @click="goToDetails(room.roomId.toString())"
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
            Created by {{ room.creator.firstName }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>
