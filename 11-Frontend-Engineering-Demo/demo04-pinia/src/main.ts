import {createApp} from 'vue'
import App from './App.vue'
import router from "./router/router.ts";
import {createPinia} from "pinia";

const app = createApp(App);
app.use(router);

// 开启全局的Pinia功能
let pinia = createPinia();
app.use(pinia);

app.mount('#app')
