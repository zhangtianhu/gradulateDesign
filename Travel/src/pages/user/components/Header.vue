<template>
  <div class="header">
    <router-link to="/">
      <div class="header-left">
        <div class="iconfont back-icon">
          &#xe624;
          <span>主页</span>
        </div>
      </div>
    </router-link>
    <router-link to="/setting">
      <div class="iconfont header-right">
        设置
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "UserHeader",
  data: function () {
    return {

    }
  }
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  a
    color black
  .header
    position relative
    background-color $bgColor
    height .86rem
    line-height .86rem
    .iconfont
      color white
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
      color white
</style>
