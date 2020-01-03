<template>
  <div class="list" ref="wrapper">
    <div>
      <div class="area">
        <div class="title border-topbottom">当前城市</div>
        <div class="button-list">
          <div class="button-wrapper">
            <div class="button">{{this.currentCity}}</div>
          </div>
        </div>
      </div>
      <div class="area">
        <div class="title border-topbottom">热门城市</div>
        <div class="button-list">
          <div class="button-wrapper"
               v-for="(item, index) of hotCities"
               :key="index"
               @click="handleCityClick(item.name)"
          >
            <div class="button">{{item.name}}</div>
          </div>
        </div>
      </div>
      <!--
        由于这里的循环的是一个Object类型所以它的index就是每个json的对象名
      -->
      <div class="area"
           v-for="(item, index) of cities"
      >
        <div class="title border-topbottom" :ref="index">
          {{index}}
        </div>
        <div class="item-list">
          <div class="item border-bottom"
               v-for="city of item"
               @click="handleCityClick(city.name)"
          >
            {{city.name}}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// 使用Better-Scroll组件实现滚动效果
import Bscroll from 'better-scroll'
import { mapState, mapMutations } from 'vuex'
export default {
  name: "CityList",
  props: {
    hotCities: Array,
    cities: Object
  },
  computed: {
    letters: function () {
      const letters = []
      for (let i in this.cities){
        letters.push(i)
      }
      return letters
    },
    ...mapState({
      currentCity: 'city'
    })
  },
  mounted: function () {
    this.scroll = new Bscroll(this.$refs.wrapper)
  },
  methods: {
    ...mapMutations({
      changeCity: 'changeCity'
    }),
    touchstart:function (e) {
      // 使用 better-scroll 的 scrollToElement 方法实现跳转
      // scrollToElement传入的值必须是DOM元素或者DOM选择器
      const index = this.$refs[e][0]
      this.scroll.scrollToElement(index)
    },
    handleCityClick: function (city) {
      // 通过调用commit方法让Mutations去改变数据的状态
      // 注意：可以跳过dispatch方法直接使用commit方法
      // 详细可以参照store文件夹下的vuex.png图片
      // this.$store.commit('changeCity', city)
      this.changeCity(city)
      // 使用router脚本去调转页面
      this.$router.push('/')
    }
  }
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  // 这个写法相当于.border-topbottom:before{}.border-topbottom:after{}
  .border-topbottom
    &:before
      border-color: #ccc
    &:after
      border-color: #ccc
  .border-bottom
    &:before
      border-color: #ccc
  .list
    overflow hidden
    position absolute
    top 1.58rem
    left 0
    right 0
    bottom 0
    .title
      line-height .54rem
      background #eee
      padding-left .2rem
      color #666
      font-size .26rem
    .button-list
      overflow hidden
      padding .1rem .6rem .1rem .1rem
      .button-wrapper
        float left
        width 33.33%
        .button
          margin .1rem
          padding .1rem 0
          text-align center
          border: .02rem solid #ccc
          border-radius .06rem
    .item-list
      .item
        line-height .76rem
        color #666
        padding-left .2rem
</style>
