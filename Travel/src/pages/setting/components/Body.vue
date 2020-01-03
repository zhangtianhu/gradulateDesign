<template>
  <div class="body">
    <div class="border-bottom nav">
      <div class="font">
        账号管理
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav">
      <div class="font">
        手机号
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav mt">
      <div class="font">
        安全中心
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav">
      <div class="font">
        支付设置
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav">
      <div class="font">
        密码设置
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav">
      <div class="font">
        隐私
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav">
      <div class="font">
        通用
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav mt">
      <div class="font">
        求助反馈
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <div class="border-bottom nav">
      <div class="font">
        关于
      </div>
      <div class="icon iconfont">
        &#xe634;
      </div>
    </div>
    <el-button class="border-bottom mt out" @click="exit">退出登录</el-button>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: "SettingBody",
  computed: {
    ...mapState(['token'])
  },
  methods: {
    // 清除本地Token并跳转到首页
    exit: function () {
      if(this.token) {
        this.$store.state.token = ''
      }
      this.$router.push("/")
    }
  }
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  .body
    background #f4f4f4
    .nav
      line-height .8rem
      background white
      color #6a6a6a
      display flex
      justify-content space-between
      .font
        padding-left .35rem
      .icon
        padding-right .3rem
        font-size .2rem
        font-weight bolder
        color #cacaca
    .mt
      margin-top: .35rem
    .out
      width 100%
      text-align center
      border 0
      font-size .32rem
      color $bgColor
</style>

