// 从vue框架中引入一个createApp函数
import {createApp} from 'vue'
// 导入全局的css样式文件，该文件的样式作用到所有的.vue元素上
import './style.css'
// 导入类一个App.vue的组件，并起一个别名为App
import App from './App.vue'
// 使用引入的App组件生成一个对象，将app对象挂在到id值为app的元素上
createApp(App).mount('#app')
// 在index.html中的<div id="app"></div>这个标签中插入这个对象