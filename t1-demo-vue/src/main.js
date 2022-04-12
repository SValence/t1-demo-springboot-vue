import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "./plugins/element.js";
import jQuery from 'jquery'
import $ from 'jquery'
import axios from "axios";
import qs from 'qs'
import './assets/icon/iconfont.css';

// 引入全局常量
import constant from './util/const.js'
// 加载全局常量插件
Vue.use(constant);

Vue.config.productionTip = false;

axios.defaults.baseURL = 'http://localhost:9000';
Vue.prototype.$axios = axios;
Vue.prototype.$qs = qs;
Vue.prototype.$jQuery = jQuery;

new Vue({
    jQuery,
    $,
    router,
    store,
    // conUtil,
    render: (h) => h(App),
}).$mount("#app");
