<template>
  <div>
    <div class="title">
      <img class="like-img" src="http://img1.qunarzz.com/piao/fusion/1711/89/ebc329f16c55bb02.png"/>
      <span>猜你喜欢</span>
    </div>
    <ul>
      <li class="item border-bottom"  v-for="(item, index) of list" :key="index">
        <div class="item-img-wrapper">
          <img class="item-img" :src="item.imgUrl"/>
        </div>
        <div class="item-info">
          <p class="item-title">{{item.title}}</p>
          <p class="item-desc">{{item.desc}}</p>
          <button class="item-button">查看详情</button>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
    export default {
      name: "HomeRecommend",
      props: {
        list: Array
      }
    }
</script>

<style scoped lang="stylus">
  @import "~styles/mixins.styl"
  .title
    margin-top .1rem
    line-height .8rem
    background #eee
    // 首行文本缩进
    text-indent .2rem
    .like-img
      width .32rem
      height .32rem
      margin-top -.1rem
  .item
    overflow hidden
    display flex
    height 1.9rem
    .item-img
      width 1.7rem
      height 1.7rem
      padding .1rem
    .item-info
      flex 1
      padding .1rem
      min-width 0
      .item-title
        line-height .54rem
        font-size .32rem
        ellipsis()
      .item-desc
        line-height .4rem
        color #ccc
        ellipsis()
      .item-button
        line-height .44rem
        margin-top .16rem
        background #ff9300
        padding 0 .2rem
        border-radius .06rem
        color #ffffff
</style>
