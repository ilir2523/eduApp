import LoginVue from "@/components/Login.vue";
import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import Register from "../components/Register.vue";
import RoomDetails from "../components/RoomDetails.vue";
import Rooms from "../components/Rooms.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      redirect: "/rooms",
      name: "home",
      component: HomeView,
      children: [
        {
          path: "/rooms",
          name: "rooms",
          component: Rooms,
        },
        {
          path: "/rooms/:id",
          component: RoomDetails,
          name: "room-details",
        },
      ],
    },
    {
      path: "/login",
      name: "login",
      component: LoginVue,
    },
    {
      path: "/register",
      name: "register",
      component: Register,
    },
  ],
});

export default router;
