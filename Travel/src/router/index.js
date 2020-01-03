import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/home/Home'
import City from '@/pages/city/City'
import Login from '@/pages/login/Login'
import Register from '@/pages/register/Register'
import User from '@/pages/user/User'
import Setting from '@/pages/setting/Setting'
import Order from '@/pages/order/Order'

Vue.use(Router)

// requireAuth true:需验证 false:无需验证
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta: {
        requireAuth: false
      }
    },
    {
      path: '/city',
      name: 'City',
      component: City,
      meta: {
        requireAuth: false
      }
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        requireAuth: false
      }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register,
      meta: {
        requireAuth: false
      }
    },
    {
      path: '/user',
      name: 'User',
      component: User,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/setting',
      name: 'Setting',
      component: Setting,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/order',
      name: 'Order',
      component: Order,
      meta: {
        requireAuth: true
      }
    }
  ]
})
