import Vue from 'vue'
import App from './App.vue'
import Antd from 'ant-design-vue';
import { Form } from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import axios from 'axios';


Vue.config.productionTip = false

Vue.use(Antd);
Vue.use(Form)
Vue.prototype.$axios = axios //全局注册，使用方法为:this.$axios
new Vue({
  render: h => h(App),
}).$mount('#app')
