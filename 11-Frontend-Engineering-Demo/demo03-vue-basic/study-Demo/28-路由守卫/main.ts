import {createApp} from "vue";
import App from "./App.vue";

// 引入pinia
import {createPinia} from 'pinia';

// 设置启动路由
import router from '@/router/router'

const app = createApp(App)

app.use(router)

// 创建pinia
const pinia = createPinia()
//安装pinia
app.use(pinia)
app.mount('#app')
