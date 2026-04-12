import { createApp } from 'vue'
import App from './App.vue'
import router from "./router/router.ts";
import pinia from "./pinpa.ts";

const app = createApp(App);
app.use(router)

app.use(pinia)

app.mount('#app')
