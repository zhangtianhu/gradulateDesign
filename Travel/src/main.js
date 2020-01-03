import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store' // 自动寻找store文件夹里的文件
import axios from 'axios'
// 解决移动端click事件延迟的问题 需要用npm install fastclick --save
import fastclick from 'fastclick'
import ElementUI from 'element-ui'
import VueAwesomeSwiper from 'vue-awesome-swiper'
// 初始化所有平台的样式
import 'styles/reset.css'
// 解决多倍屏1像素边框问题
import 'styles/border.css'
import 'styles/iconfont.css'
import 'swiper/dist/css/swiper.css'
import 'element-ui/lib/theme-chalk/index.css'

import UserRequest from './request/user/UserRequest'


Vue.config.productionTip = false
fastclick.attach(document.body)
Vue.use(VueAwesomeSwiper)
// 使用饿了么UI组件
Vue.use(ElementUI)
new Vue({
  el: '#app',
  router,
  store,
  components: { App: App },
  template: '<App/>'
})

router.beforeEach((to, from, next) => {
  if(to.meta.requireAuth) { // 判断该请求是否需要验证
    if(store.state.token) { // 若本地有token
      // 判断token是否过期
      axios.get(UserRequest.judgeTokenUrl, {
        headers: {
          'token': store.state.token
        }
      }).then(res => {
        res = res.data
        // 判断若已经失效则清除本地token值,并跳转到登录页面
        if(res) { // res => true 则已经失效
          store.state.token = ''
          next({
            path: '/login',
            query: {redirect: to.fullPath}
          })
        }else{
          next()
        }
      })
    }else{
      next({
        path: '/login',
        query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  }else {
    next()
  }
})
