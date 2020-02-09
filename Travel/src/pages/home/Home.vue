<template>
  <div>
    <home-hander></home-hander>
    <home-swiper :list="swiperList"></home-swiper>
    <home-icons :list="iconList"></home-icons>
    <home-hot-crunchies :list="crunchiesList"></home-hot-crunchies>
    <home-recommend :list="recommendList"></home-recommend>
    <home-weekend :list="weekendList"></home-weekend>
    <home-bottom></home-bottom>
  </div>
</template>

<script>
  import HomeHander from './components/Header'
  import HomeSwiper from './components/Swiper'
  import HomeIcons from './components/Icons'
  import HomeRecommend from './components/Recommend'
  import HomeWeekend from './components/Weekend'
  import HomeHotCrunchies from './components/HomeHotCrunchies'
  import HomeBottom from './components/Bottom'
  import axios from 'axios'
  import { mapState } from 'vuex'
  import global from '@/Global'

  export default {
    name: 'Home',
    components: {
      HomeHander,
      HomeSwiper,
      HomeIcons,
      HomeRecommend,
      HomeWeekend,
      HomeHotCrunchies,
      HomeBottom
    },
    data: function() {
      return {
        lastCity: '',
        swiperList: [],
        iconList: [],
        recommendList: [],
        weekendList: [],
        crunchiesList: []
      }
    },
    computed: {
      ...mapState({
        city: 'city'
      })
    },
    methods: {
      getHomeInfo : function () {
        axios.get(global.homeList)
          .then(res => {
            res = res.data
            // if(res.code === 200){
              const data = res.data
              this.swiperList = data.swiperList
              this.iconList = data.iconList
              this.recommendList = data.recommendList
              this.weekendList = data.weekendList
              this.crunchiesList = data.crunchiesList
            // }
          }).catch(error => {
            // this.$notify.error({
            //   title: '错误',
            //   message: '系统出错'
            // })
        })
      }
    },
    // 页面挂载好后执行getHomeInfo方法
    mounted: function () {
      this.lastCity = this.city
      this.getHomeInfo()
    },
    // 当使用keep-alive组件时才能调用
    // 当页面被显式的时候执行
    activated: function () {
      // 判断现在的城市与上一次的城市是否相同
      // 若城市不相同调用getHomeInfo触发ajax调用
      if (this.lastCity !== this.city) {
        this.lastCity = this.city
        this.getHomeInfo()
      }
    }
  }
</script>

<style scoped>

</style>
