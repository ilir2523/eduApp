<template>
  <div
    class="flex min-h-full items-center justify-center py-12 px-4 sm:px-6 lg:px-8"
  >
    <div class="w-full max-w-md space-y-8">
      <div>
        <img
          class="mx-auto h-12 w-auto"
          src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600"
          alt="Your Company"
        />
        <h2
          class="mt-6 text-center text-3xl font-bold tracking-tight text-gray-900"
        >
          Sign up to your account
        </h2>
        <p class="mt-2 text-center text-sm text-gray-600">
          Or
          {{ " " }}
          <router-link
            to="/login"
            class="font-medium text-indigo-600 hover:text-indigo-500"
            >Sign in</router-link
          >
        </p>
      </div>
      <form class="mt-8 space-y-6" action="#" method="POST">
        <input type="hidden" name="remember" value="true" />
        <div class="grid gap-6 mb-6 md:grid-cols-2">
          <div>
            <input
              id="firstName"
              name="firstName"
              type="text"
              autocomplete="firstName"
              class="relative block w-full appearance-none rounded-none rounded-t-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
              placeholder="First Name"
              v-model="firstName"
            />
          </div>
          <div>
            <input
              id="lastName"
              name="lastName"
              type="text"
              autocomplete="lastName"
              class="relative block w-full appearance-none rounded-none rounded-t-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
              placeholder="Last Name"
              v-model="lastName"
            />
          </div>
          <div>
            <input
              id="username"
              name="username"
              type="text"
              autocomplete="username"
              class="relative block w-full appearance-none rounded-none rounded-b-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
              placeholder="Username"
              v-model="username"
            />
          </div>
          <div>
            <label for="password" class="sr-only">Password</label>
            <input
              id="password"
              name="password"
              type="password"
              autocomplete="current-password"
              class="relative block w-full appearance-none rounded-none rounded-b-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
              placeholder="Password"
            />
          </div>
        </div>

        <button
          id="dropdownDefault"
          data-dropdown-toggle="dropdown"
          class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2.5 text-center inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          type="button"
        >
          {{ schoolType }}
          <svg
            class="ml-2 w-4 h-4"
            aria-hidden="true"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M19 9l-7 7-7-7"
            ></path>
          </svg>
        </button>
        <!-- Dropdown menu -->
        <div
          id="dropdown"
          class="hidden z-10 w-44 bg-white rounded divide-y divide-gray-100 shadow dark:bg-gray-700"
          data-popper-reference-hidden=""
          data-popper-escaped=""
          data-popper-placement="bottom"
          style="
            position: absolute;
            inset: 0px auto auto 0px;
            margin: 0px;
            transform: translate3d(0px, 251.2px, 0px);
          "
        >
          <ul
            class="py-1 text-sm text-gray-700 dark:text-gray-200"
            aria-labelledby="dropdownDefault"
            v-for="(type, index) in schoolTypes"
            :key="index"
          >
            <li>
              <a
                class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                @click="schoolType = type"
                >{{ type }}</a
              >
            </li>
          </ul>
        </div>

        <button
          id="dropdownDefault"
          data-dropdown-toggle="dropdown"
          class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2.5 text-center inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          type="button"
        >
          {{ schoolName }}
          <svg
            class="ml-2 w-4 h-4"
            aria-hidden="true"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M19 9l-7 7-7-7"
            ></path>
          </svg>
        </button>
        <!-- Dropdown menu -->
        <div
          id="dropdown"
          class="hidden z-10 w-44 bg-white rounded divide-y divide-gray-100 shadow dark:bg-gray-700"
          data-popper-reference-hidden=""
          data-popper-escaped=""
          data-popper-placement="bottom"
          style="
            position: absolute;
            inset: 0px auto auto 0px;
            margin: 0px;
            transform: translate3d(0px, 251.2px, 0px);
          "
        >
          <ul
            class="py-1 text-sm text-gray-700 dark:text-gray-200"
            aria-labelledby="dropdownDefault"
            v-for="(school, index) in schoolsByType"
            :key="index"
          >
            <li>
              <a
                class="block py-2 px-4 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                @click="schoolType = school"
                >{{ school }}</a
              >
            </li>
          </ul>
        </div>

        <div class="flex items-center justify-between">
          <div class="flex items-center">
            <input
              id="remember-me"
              name="remember-me"
              type="checkbox"
              class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
            />
            <label for="remember-me" class="ml-2 block text-sm text-gray-900"
              >Remember me</label
            >
          </div>
        </div>

        <div>
          <button
            type="submit"
            class="group relative flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
          >
            <span class="absolute inset-y-0 left-0 flex items-center pl-3">
              <LockClosedIcon
                class="h-5 w-5 text-indigo-500 group-hover:text-indigo-400"
                aria-hidden="true"
              />
            </span>
            Sign Up
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script lang="ts">
import { RouterLink } from "vue-router";
import axios from "axios";

export default {
  name: "RegisterComponent",
  components: {
    RouterLink,
  },
  data() {
    return {
      firstName: "",
      lastName: "",
      username: "",
      password: "",
      schoolType: "School Type",
      schoolName: "School Name",
      schoolTypes: {},
      schoolsByType: {},
    };
  },
  methods: {
    getSchoolType() {
      axios
        .get("http://localhost:8080/types")
        .then((response) => {
          console.log(response.data);
          this.schoolTypes = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getSchoolsByType() {
      axios
        .get("http://localhost:8080/schools")
        .then((response) => {
          console.log(response.data);
          this.schoolsByType = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    async login(data: any) {
      await axios
        .post("http://localhost:8080/api/user/register", data, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then((res) => {
          console.log(res.data.data);
          localStorage.setItem("user", JSON.stringify(res.data.data));
        });
    },
    submit(e: any) {
      let data = {
        firstName: this.firstName,
        lastName: this.lastName,
        username: this.username,
        password: this.password,
        schoolDto: {},
      };
      this.login(data);
      e.preventDefault();
      this.$router.push("/");
    },
  },
};
</script>
