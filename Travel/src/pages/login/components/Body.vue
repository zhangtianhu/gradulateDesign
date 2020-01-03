<template>
  <transition name="el-fade-in-linear">
    <div class="body" v-show="this.mobileLogin">
      <div class="login-div iconfont" @click="changeMobileLogin"><div class="icon border-right">&#xe63d;</div><div class="icon-font">手机或邮箱</div></div>
      <div class="login-div">或</div>
      <div class="login-div iconfont" @click="qqLogin"><div class="icon" style="color: #2190a4">&#xe62b;</div><div class="icon-font">QQ登录</div></div>
      <div class="login-div iconfont"><div class="icon" style="color: green">&#xe66c;</div><div class="icon-font">微信登录</div></div>
    </div>
  </transition>
</template>

<script>
import { mapState} from 'vuex'
import axios from 'axios'
import qqsdk from 'qqsdk'
import global from '@/Global'
export default {
  name: "LoginBody",
  computed: {
    ...mapState(['mobileLogin'])
  },
  methods: {
    changeMobileLogin: function (e) {
      this.$store.commit('changeMobileLogin', !this.mobileLogin)
    },
    qqLogin: function (e) {
      // const sdk = qqsdk.create({appid: global.qqAppId, appkey: global.qqKey, debug: true})
      // sdk.api = (res) => {
      //
      // }
    }
  }
}
</script>

<style scoped lang="stylus">
  .body
    display: flex
    justify-items center
    flex-direction column
    align-items center
    width 100%
    .login-div
      margin-top .8rem
      line-height .9rem
      flex: 1;
      width 5.7rem
      height .9rem
      background white
      border-radius .1rem
      .border-right
        &:before
          border-color: #eaeaea
      div
        float left
      .icon-font
        width 4rem
        text-align center
      .icon
        text-align center
        width .9rem
        font-size .4rem
      &:nth-child(1)
        .icon
          font-size .5rem
      &:nth-child(2)
        background-color transparent
        margin-top .2rem
        margin-bottom 0
        color #909090
        text-align center
      &:nth-child(3)
        color white
        margin-top .2rem
        background-color #00b8d2
      &:nth-child(4)
        color white
        background-color #35c207
  // 当高小于568px
  @media screen and (min-height: 568px) // iPhone 5/5S/5SE
    .body
      .login-div
        &:nth-child(4)
          margin-bottom 29.8%
  @media screen and (min-height: 640px) // Galaxy S5
    .body
      .login-div
        &:nth-child(4)
          margin-bottom 46.5%
  @media screen and (min-height: 667px) // iPhone 6/7/8
    .body
      .login-div
        &:nth-child(4)
          margin-bottom 51.7%
  @media screen and (min-height: 736px) // iPhone 6/7/8 Plus
    .body
      .login-div
        &:nth-child(4)
          margin-bottom 63.5%
  @media screen and (min-height: 812px) // iPhoneX
    .body
      .login-div
        &:nth-child(4)
          margin-bottom 90%
  @media screen and (min-height: 1024px) // iPad
    .body
      .login-div
        &:nth-child(4)
          margin-bottom 71.7%
</style>
