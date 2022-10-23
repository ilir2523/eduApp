<script setup lang="ts">
const navMenu = [
  { name: "Quizes", href: "quizes", id: 1 },
  { name: "Links", href: "links", id: 2 },
  { name: "Members", href: "members", id: 3 },
];

const members = [
  { name: "Ariel", id: 1 },
  { name: "Erik", id: 2 },
  { name: "Ilir", id: 3 },
];

const quizes = [
  { name: "Quiz 1", id: 1 },
  { name: "Quiz 2", id: 2 },
  { name: "Quiz 3", id: 3 },
];

const links = [
  { name: "Link 1", id: 1 },
  { name: "Math Book", id: 2 },
  { name: "Link to Test", id: 3 },
];
</script>
<script lang="ts">
export default {
  name: "RoomDetailsComponent",
  data() {
    return {
      path: "",
    };
  },
  methods: {
    change(path: string, e: any) {
      e.preventDefault();
      this.path = path;
    },
  },
};
</script>

<template>
  <div>
    <div class="border-b border-gray-200 dark:border-gray-700">
      <ul
        class="flex flex-wrap -mb-px text-sm font-medium text-center text-gray-500 dark:text-gray-400"
      >
        <li class="mr-2" v-for="menu in navMenu" :key="menu.id">
          <a
            :href="menu.href"
            @click="change(menu.href, $event)"
            class="inline-flex p-4 rounded-t-lg border-b-2 border-transparent hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300 group"
            :class="
              path == menu.href ? 'text-blue-600 active border-blue-600' : ''
            "
            >{{ menu.name }}
          </a>
        </li>
      </ul>
    </div>
    <div class="flex flex-col gap-2 mb-6" v-if="path == 'members'">
      <div
        v-for="member in members"
        :key="member.id"
        class="m-2 w-72 h-20 p-6 max-w-sm bg-white rounded-lg border"
      >
        <h5 class="mb-2 text-2xl font-bold text-gray-900 dark:text-white">
          {{ member.name }}
        </h5>
      </div>
    </div>
    <div class="flex flex-col gap-2 mb-6" v-if="path == 'quizes' || path == ''">
      <div
        v-for="quiz in quizes"
        :key="quiz.id"
        class="m-2 w-72 h-20 p-6 max-w-sm bg-white rounded-lg border border-gray-200 shadow-md hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700"
      >
        <h5 class="mb-2 text-2xl font-bold text-gray-900 dark:text-white">
          {{ quiz.name }}
        </h5>
      </div>
    </div>
    <div class="flex flex-col gap-2 mb-6" v-if="path == 'links'">
      <div
        v-for="link in links"
        :key="link.id"
        class="m-2 w-72 h-20 p-6 max-w-sm bg-white rounded-lg border border-gray-200 shadow-md hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700"
      >
        <h5 class="mb-2 text-2xl font-bold text-gray-900 dark:text-white">
          {{ link.name }}
        </h5>
      </div>
    </div>
  </div>
</template>
