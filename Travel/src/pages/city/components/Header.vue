<template>
    <div class="header">
      <router-link to="/">
        <div class="header-left">
          <div class="iconfont back-icon">&#xe624;</div>
        </div>
      </router-link>
      城市选择
    </div>
</template>

<script>
    export default {
        name: "CityHeader"
    }
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  .header
    position relative
    overflow hidden
    height $headerHeight
    line-height $headerHeight
    text-align center
    color white
    background $bgColor
    font-size .32rem
    .header-left
      position absolute
      top 0
      left 0
      width .64rem
      float left
      .back-icon
        text-align center
        font-size .4rem
        color white
</style>
