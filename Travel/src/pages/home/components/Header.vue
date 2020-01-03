<template>
    <div class="header">
      <div class="header-left">
        <div class="iconfont back-icon">&#xe624;</div>
      </div>
      <div class="header-input">
        <span class="iconfont">&#xe632;</span>
        输入城市/景点/游玩主题
      </div>
      <router-link to="/city">
        <div class="header-right">
          <!-- {{this.$stroe.state.city}} -->
          {{this.city}}
          <span class="iconfont arrow-icon">&#xe6aa;</span>
        </div>
      </router-link>
    </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: "HomeHeader",
  computed: {
    // mapState通过扩展运算符将store.$state.city 映射this.city
    // 扩展运算符（ spread ）是三个点（...）将一个数组转为用逗号分隔的参数序列。
    ...mapState({
      city: 'city'
    })
  }
}
</script>

<!--
  使用 stylus css语法
  1 ÷ 父元素的font-size × 需要转换的像素值 = em值
-->
<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  .header
    display: flex
    line-height .86rem
    background $bgColor
    color: #fff
    .header-left
      width $headerHeight
      float left
      .back-icon
        text-align center
        font-size .4rem
    .header-input
      flex: 1
      height .64rem
      margin-top .12rem
      margin-left .2rem
      padding-left .2rem
      background #fff
      border-radius .1rem
      color #ccc
      line-height .64rem
    .header-right
      min-width 1.04rem
      padding 0 .1rem
      float right
      text-align center
      color white
      .arrow-icon
        margin-left -.04rem
        font-size .24rem
</style>
