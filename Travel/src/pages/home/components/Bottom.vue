<template>
    <div class="bottom">
      <div class="distance"></div>
      <div class="tip">
        <span class="iconfont">&#xe620;</span>票面价是指通过景区指定窗口售卖的纸质门票上标注的价格
      </div>
      <ul class="home-nav-wrapper">
        <li><span class="iconfont">&#xe649;</span>机票</li>
        <li><span class="iconfont">&#xe64a;</span>酒店</li>
        <li><span class="iconfont">&#xe692;</span>公寓</li>
        <li><span class="iconfont">&#xe727;</span>更多</li>
      </ul>
      <ul class="footer_nav border-bottom">
        <router-link to="/user">
          <li v-show="this.$store.state.token">个人中心</li>
        </router-link>
        <router-link to="/login">
          <li v-show="!this.$store.state.token">登录</li>
        </router-link>
        <li v-show="!this.$store.state.token">我的订单</li>
        <li>最近浏览</li>
        <li>关于我们</li>
      </ul>
      <ul class="mobile_pc">
        <li>触屏版</li>
        <li style="color: #25a4bb">电脑版</li>
      </ul>
      <div class="copyright">
        <span>Copyright © 2018 name All rights reserved 李光耀</span>
      </div>
    </div>
</template>

<script>
export default {
  name: "HomeBottom"
}
</script>

<style scoped lang="stylus">
  .bottom
    width 100%
    height 3.5rem
    background-color #f3f3f3
    ul
      overflow-x hidden
      white-space nowrap //不允许换行
      line-height .8rem
      text-align center
      li
        display inline-block
        .iconfont
          font-size .4rem
          color #aeaeae
    .home-nav-wrapper
      li
        width 1.3rem
        color #aeaeae
    .footer_nav
      text-align left
      li
        padding-left .45rem
        color #25a4bb
    .border-bottom
      &:before
        border-color: #ccc
    .mobile_pc
      li
        &:nth-child(2)
          margin-left .5rem
    .distance
      height .1rem
      background-color #eee
    .tip
      background-color white
      line-height .6rem
      font-size .2rem
      color #666
      padding-left .1rem
      .iconfont
        font-size .2rem
    .copyright
      text-align center
      color grey
</style>
