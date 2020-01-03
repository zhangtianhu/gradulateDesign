<template>
  <div>
    <div class="title">
      <span>周末去哪儿</span>
    </div>
    <ul>
      <li class="item border-bottom"  v-for="(item, index) of list" :key="index">
        <div class="item-img-wrapper">
          <img class="item-img" :src="item.imgUrl"/>
        </div>
        <div class="item-info">
          <p class="item-title">{{item.title}}</p>
          <p class="item-desc">{{item.desc}}</p>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: "HomeWeekend",
    props: {
      list: Array
    }
  }
</script>

<style scoped lang="stylus">
  @import "~styles/mixins.styl"
  .title
    line-height .8rem
    background #eee
    // 首行文本缩进
    text-indent .2rem
  .item-img-wrapper
    overflow hidden
    height 0
    padding-bottom 33.9%
  .item-img
    width 100%
  .item-info
    padding .1rem
    .item-title
      margin-left .2rem
      line-height .54rem
      font-size .28rem
      ellipsis()
    .item-desc
      margin-left .2rem
      line-height .4rem
      color rgba(0, 0, 0, 0.63)
      font-size .2rem
      ellipsis()
</style>
