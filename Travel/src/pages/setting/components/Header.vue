<template>
  <div class="header">
    <router-link to="/user">
      <div class="header-left">
        <div class="iconfont back-icon">
          &#xe624;
          <span>设置</span>
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>
  export default {
    name: "SettingHeader"
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
</style>
