<template>
  <div class="header">
    <router-link to="/">
      <div class="header-left">
          <div class="iconfont back-icon">
            &#xe624;
            <span>登录</span>
          </div>
      </div>
    </router-link>
    <router-link to="/register">
      <div class="iconfont header-right" v-show="this.mobileLogin">
        注册
      </div>
    </router-link>
  </div>
</template>

<script>
import { mapState} from 'vuex'
export default {
  name: "LoginHeader",
  computed: {
    ...mapState(['mobileLogin'])
  },
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  a
    color black
  .header
    height .86rem
    line-height .86rem
    .header-left
      width 2rem
      float left
      .back-icon
        text-align center
    .header-right
      float right
      width 1rem
      padding 0 .1rem
      text-align center
      color black
</style>
