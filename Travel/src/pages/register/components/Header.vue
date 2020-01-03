<template>
  <div class="header">
    <router-link to="/">
      <div class="header-left" @click="changeSMS">
          <div class="iconfont back-icon">
            &#xe624;
            <span>登录</span>
          </div>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "RegisterHeader",
  methods: {
    changeSMS: function(e) {
      if(this.$store.state.sms) {
        this.$store.state.sms = false
      }
    }
  }
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
</style>
