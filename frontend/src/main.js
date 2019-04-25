import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en'
import config from '@/config'

Vue.use(ElementUI, { locale })
Vue.use(ElementUI)

Vue.config.productionTip = false;

config();

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
