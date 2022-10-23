<script setup lang="ts">
import Navbar from "./Navbar.vue";
</script>
<script lang="ts">
export default {
  name: "ProfileComponent",
  data() {
    return {
      updateState: true,
      user: JSON.parse(localStorage.getItem("user")!),
    };
  },
  methods: {
    update(type: string) {
      if (type == "update") {
        this.updateState = !this.updateState;
      } else if (type == "post") {
        console.log("");
        this.updateState = !this.updateState;
      } else {
        this.updateState = !this.updateState;
      }
    },
  },
};
</script>
<template>
  <nav>
    <Navbar />
  </nav>
  <div class="flex justify-center mt-32">
    <div class="w-2/6">
      <h1>Your Profile</h1>
      <div class="relative flex py-5 items-center">
        <div class="flex-grow border-t border-gray-400"></div>
        <div class="flex-grow border-t border-gray-400"></div>
      </div>
      <div class="grid gap-6 mb-6 md:grid-cols-2">
        <div>
          <label
            for="first_name"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
            >First name</label
          >
          <input
            type="text"
            id="first_name"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="user.firstName"
            :disabled="updateState"
          />
        </div>
        <div>
          <label
            for="last_name"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
            >Last name</label
          >
          <input
            type="text"
            id="last_name"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="user.lastName"
            :disabled="updateState"
          />
        </div>
        <div>
          <label
            for="username"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
            >Last name</label
          >
          <input
            type="text"
            id="username"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="user.username"
            :disabled="updateState"
          />
        </div>
        <div>
          <button
            type="button"
            @click="update('update')"
            v-if="updateState == true"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800"
          >
            Update
          </button>
          <button
            type="button"
            v-if="updateState == false"
            @click="update('post')"
            class="focus:outline-none text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 dark:bg-purple-600 dark:hover:bg-purple-700 dark:focus:ring-purple-900"
          >
            Save
          </button>
          <button
            type="button"
            v-if="updateState == false"
            @click="update('')"
            class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900"
          >
            Cancel
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
