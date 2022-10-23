<!-- eslint-disable vue/require-v-for-key -->
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

        <v-select
          placeholder="School Type"
          v-model="schoolType"
          :options="schoolTypes"
        ></v-select>
        <v-select
          placeholder="School"
          v-model="school"
          :options="schoolsByType"
          :disabled="!schoolType"
        ></v-select>

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
      schoolType: "",
      school: "",
      schoolTypes: [],
      schoolsByType: [],
      schoolDto: {},
    };
  },
  methods: {
    formatData(res: Array<object>) {
      let data = [...res];
      res.forEach((item: any) => {
        data.push({ id: item.id, label: item.name });
      });
      return data;
    },
    formatDataForSchool(res: Array<object>) {
      let data = [...res];
      res.forEach((item: any) => {
        data.push({ id: item.schoolId, label: item.name });
      });
      return data;
    },
    getSchoolType() {
      axios
        .get("http://localhost:8080/api/schools/types")
        .then((response) => {
          console.log(response.data.data);
          this.schoolTypes = this.formatData(response.data.data);
          this.getSchoolsByType(this.schoolType);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getSchoolsByType(type: string) {
      axios
        .get("http://localhost:8080/api/schools", {
          params: {
            type: this.schoolTypes.find((_st) => this.schoolType == _st.name),
          },
        })
        .then((response) => {
          console.log(response.data.data);
          this.schoolsByType =
            this.formatDataForSchool(response.data.data) || [];
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
        schoolDto:
          this.schoolsByType.find((_s) => this.school == _s.name) || {},
      };
      console.log(this.school);
      this.login(data);
      e.preventDefault();
      this.$router.push("/");
    },
  },
  mounted() {
    this.getSchoolType();
    this.getSchoolsByType();
  },
};
</script>
