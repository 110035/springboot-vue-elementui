import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router/index.js'
import axios from 'axios'
import store from './store'

Vue.use(VueRouter)
Vue.use(ElementUI)


Vue.prototype.axios = axios

new Vue({
  el: '#app',
    router,
    store,
    components: {App},
    template: '<App/>'

})

