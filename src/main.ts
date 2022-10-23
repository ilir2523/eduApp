import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";

import "./assets/main.css";
import vSelect from "vue-select";
import "vue-select/dist/vue-select.css";

const app = createApp(App);

app.use(createPinia());
app.use(router);

app.mount("#app");

app.component("v-select", vSelect);
